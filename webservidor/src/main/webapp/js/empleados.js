'use strict';

const URL = 'http://localhost:8080/webservidor/api/v2/empleados';

window.addEventListener('DOMContentLoaded', () => {
	cargarListado();
	
	const form = document.querySelector('form');
	
	form.addEventListener('submit', async (event) => {
		event.preventDefault();
		
		const formData = new FormData(event.target);
		const empleado = Object.fromEntries(formData.entries());
		
		console.log(empleado);
		
		const respuesta = await fetch(URL, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(empleado)
		});
		
		const insertado = await respuesta.json();
		
		console.log(insertado);
		
		cargarListado();
	});
});

async function cargarListado() {
    const respuesta = await fetch(URL);
    const empleados = await respuesta.json();

	document.querySelector('ul').innerHTML = '';
	
    empleados.forEach(e => {
        const li = document.createElement('li');
        li.textContent = `${e.nombre} ${e.apellidos}`;
        document.querySelector('ul').appendChild(li);
    });
}
