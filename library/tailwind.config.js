/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    colors: {
       cafeOscuro: '#260909',
       claro: '#D9CE9A',
       textoClaro: '#BFA893', 
       botonLogin: '#A6524B'
    },
    extend: {},
  },
  plugins: [],
}

