console.log("FUNCIONANDO");

document.querySelector("#buscar").addEventListener("click", function() {

	filtrar();
});

const cajaFiltro = document.querySelector("#miBusqueda");



function Validar() {

	var nombres, apellidos, celular, contrasena;

	nombres = document.getElementById("nombres").value;
	apellidos = document.getElementById("apellidos").value;
	celular = document.getElementById("celular").value;
	contrasena = document.getElementById("contrasena").value;

	if (nombres == "" || apellidos == "" || celular == "" || contrasena == "") {
		alert("Por Favor! ingrese datos en el formulario");

		return false;
	}

	var patronNombres = /^[\sa-z]{3,}$/i;
	var patronApellidos = /^[\sa-z]{3,}$/i;
	var patronContrasena = /^[\sA-z]{4,8}$/i;

	var resultNombres = patronNombres.test(nombres);
	var resultApellidos = patronApellidos.test(apellidos);
	var resultContrasena = patronContrasena.test(contrasena);

	if (resultNombres == false) {
		alert("El nombre no es valido");
		return false;

	} else if (nombres.length > 15) {
		alert("El campo nombres es muy extenso");

		return false;
	}

	if (resultApellidos == false) {
		alert("El apellido no es valido");
		return false;

	} else if (apellidos.length > 15) {
		alert("El campo apellido es muy extenso");
		return false;
	}

	if (isNaN(celular)) {
		alert("Ingrese numeros en campo celular");
		return false;

	} else if (!(/^\d{9}$/.test(celular))) {

		if (celular.length < 9) {
			alert("Ingrese nueve digitos");
			return false;
		} else {
			alert("Numeros ingresados excedió lo permitido");
			return false;
		}

	}

	if (resultContrasena == false) {
		alert("La contraseña es sólo de 4-8 digitos!!!");
		return false;
	}
}




