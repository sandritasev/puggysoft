import React from "react";
import Login from "./../login/Login";
import Image from "react-bootstrap/Image";
import Navbar from "react-bootstrap/Navbar";
import i18n from "../../i18n/i18n";
import {
  AiFillFacebook
} from "react-icons/ai";
import {
  BsYoutube
} from "react-icons/bs";

import "./LoginAlcaldiaColcapirhua.css";

function LoginAlcaldiaColcapirhua () {
  return (
    <div className="puggysoft-login-alcaldia-colca-container">
      <Navbar
        className="puggysoft-login-alcaldia-colca-navbar"
        bg="primary"
        data-bs-theme="dark"
      >
        <Image
          className="puggysoft-alcaldia-colca-navbar-logo"
          src="alcaldia/colcaEscudo.jpg"
        />
        <div
          className="puggysoft-alcaldia-colca-text-container">
          {i18n.alcaldiaLoginColcapirhua.navBarText}
        </div>
      </Navbar>
      <div className="image-fader">
        <Image
          className="puggysoft-alcaldia-colca-main-image"
          src="alcaldia/alcaldia-colcapirhua-escudo.jpg"
        />
        <Image
          className="puggysoft-alcaldia-colca-main-image"
          src="alcaldia/alcaldia-colcapirhua-avanza.jpg"
        />
        <Image
          className="puggysoft-alcaldia-colca-main-image"
          src="alcaldia/alcaldia-colcapirhua-compromiso.jpg"
        />
        <Image
          className="puggysoft-alcaldia-colca-main-image"
          src="alcaldia/alcaldia-colcapirhua-mejores-oportunidades.jpg"
        />
      </div>
      <div className="image-fader image-fader-two">
        <Image
          className="puggysoft-alcaldia-colca-main-image"
          src="alcaldia/alcaldia-colcapirhua-mejores-oportunidades.jpg"
        />
        <Image
          className="puggysoft-alcaldia-colca-main-image"
          src="alcaldia/alcaldia-colcapirhua-compromiso.jpg"
        />
        <Image
          className="puggysoft-alcaldia-colca-main-image"
          src="alcaldia/alcaldia-colcapirhua-avanza.jpg"
        />
        <Image
          className="puggysoft-alcaldia-colca-main-image"
          src="alcaldia/alcaldia-colcapirhua-escudo.jpg"
        />
      </div>
      <Login
      />
      <div className="puggysoft-alcaldia-colca-links-container">
        <a
          className="puggysoft-alcaldia-colca-links-item"
          href="https://www.facebook.com/municipiodecolcapirhua"
          target="_blank"
          rel="noreferrer"
        >
          <AiFillFacebook />
          {i18n.alcaldiaLoginColcapirhua.facebook}
        </a>
        <a
          className="puggysoft-alcaldia-colca-links-item"
          href="https://www.youtube.com/channel/UCohZmqu9HSTgCPzYchEiGwA"
          target="_blank"
          rel="noreferrer"
        >
          <BsYoutube />
          {i18n.alcaldiaLoginColcapirhua.youtube}
        </a>
        <a
          className="puggysoft-alcaldia-colca-links-item"
          href="https://colcapirhua.gob.bo/"
          target="_blank"
          rel="noreferrer"
        >
          {i18n.alcaldiaLoginColcapirhua.nuestraWeb}
        </a>
        <a
          className="puggysoft-alcaldia-colca-links-item"
          href="mailto:gamc@colcapirhua.gob.bo"
        >
          {i18n.alcaldiaLoginColcapirhua.correo}
        </a>
      </div>
      <a>{i18n.alcaldiaLoginColcapirhua.derechos}</a>
    </div>
  );
}

export default LoginAlcaldiaColcapirhua;
