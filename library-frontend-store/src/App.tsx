import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './pages/Home';
import Log from './pages/Login';
import logo from './assets/logoBliblidigital.svg';
import './App.css';

const LandingPage: React.FC = () =>{
  
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Gestionar tus libros nuca fue tan facil!.
        </p>
        <Link
          to = "/home"
          className='app-link'
          >
            Ingresar
          </Link>
      </header>
    </div>  
  )
}

const App: React.FC = () => {
  return (
    <Router>
      <Routes>
        <Route path='/' element={<LandingPage />} />
        <Route path='/home' element={<Home />} />
        <Route path='login' element={<Log />} />
      </Routes>
    </Router>
  );
}

export default App;
