import React from 'react';
import logo from '../assets/logo 2.png';
import imagen1 from '../assets/image 2.svg';
import './Home.css';

const Home: React.FC = () => {
  return (
    <div className='home'>
      <header className='home-header'>
        <img src={logo} className='home-logo' alt='logo'/>
        <h1>Bienvenido a BLIBLIGITAL</h1>
      </header>
      <body className='home-body'>
        <img src={imagen1} className='home-pdf' alt='pdf'/>
        <a href="https://es.lipsum.com/" className='home-link' >
          Descarga nuestra guia inicial de usuario
        </a>
        <p> o </p>
        <p>
          Comunicate con nosotros y agendaremos una sesion inicial de usuario
        </p>
      </body>
    </div>
  );
};

export default Home;
