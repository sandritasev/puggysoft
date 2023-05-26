/**
 *
 * @param {*} valueA valueA.
 * @param {*} valueB valueB.
 * @param {*} sortBy des, asc.
 * @returns
 */
function compare (
  valueA,
  valueB,
  sortBy
) {
  let criteriaA = valueA;
  let criteriaB = valueB;
  if (typeof valueA === "string" && typeof valueB === "string") {
    criteriaA = valueA.toUpperCase();
    criteriaB = valueB.toUpperCase();
  }
  if (criteriaA < criteriaB) {
    return sortBy === "asc" ? -1 : 1;
  } if (criteriaA > criteriaB) {
    return sortBy === "asc" ? 1 : -1;
  }
  return 0;
}

/**
 *
 * @param {*} fieldName field of the object.
 * @param {*} sortBy des, asc.
 * @param {*} arrayOfObjects array to sort.
 */
function sorded (fieldName, sortBy, arrayOfObjects) {
  let arraySorted = [...arrayOfObjects];
  arraySorted = arraySorted.sort((itemA, itemB) => {
    const criteriaA = itemA[fieldName];
    const criteriaB = itemB[fieldName];
    return compare(criteriaA, criteriaB, sortBy);
  });
  return arraySorted;
}

/**
 *
 * @param {*} fieldName field of the object.
 * @param {*} sortBy des, asc.
 * @param {*} arrayOfObjects array to sort.
 */
function sort (fieldName, sortBy, arrayOfObjects) {
  let arraySorted = [...arrayOfObjects];
  arraySorted = arraySorted.sort((itemA, itemB) => {
    const criteriaA = itemA[fieldName];
    const criteriaB = itemB[fieldName];
    return sortBy === "asc" ? criteriaA.localeCompare(criteriaB) : criteriaA.localeCompare(criteriaB) * -1;
  });
  return arraySorted;
}

export default {
  sorded,
  sort
};
