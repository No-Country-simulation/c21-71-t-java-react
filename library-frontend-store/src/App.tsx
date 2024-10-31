import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './pages/Home';
import './App.css'; 
import logo from './assets/logo.png';

const LandingPage: React.FC = () => {
    return (
        <div>
            <header className="header">
            <img src={logo} className="logo" alt="logo" />
                <h1>Gestión de libros</h1>
            </header>

            <main className="main-container">
                <section className="login-container">
                    <h2>¡Ingresa aquí!</h2>
                    <input type="text" placeholder="Usuario" className="input" />
                    <input type="password" placeholder="Contraseña" className="input" />
                    <Link to="/Home" className="button">
                        Iniciar sesión
                    </Link>
                    <a href="/recover" className="link">Recuperar contraseña</a>
                </section>

                <section className="text-container">
                    <p>Gestionar tus libros nunca fue tan fácil</p>
                    <h3>¡Útil, sencillo y práctico!</h3>
                    <button className="button">Crear cuenta</button>
                </section>
            </main>
            <div>
            <footer className="footer">
                <a href="/support" className="footer-link">Soporte</a>
                <a href="/about" className="footer-link">¿Quiénes somos?</a>
            </footer> </div>
        </div>
    )
}
const App: React.FC = () => {
    return (
      <Router>
        <Routes>
          <Route path='/home' element={<Home />} />
        </Routes>
      </Router>
    );
};

export default App;
