console.log("ACTIVO");


document.querySelector("#boton").addEventListener("click", function(){
	
	traerdatos();
	
});

function traerdatos(){
	
	
	let url = `http://localhost:8080/pv1/mostrartodos`;
	
	const api = new XMLHttpRequest();
	
	api.open('GET', url, true);
	api.send();
	
	
	api.onreadystatechange = function (){
		
	if(this.readyState == 4 && this.status == 200){
		
		let usuarios= JSON.parse(this.responseText);
		console.log(usuarios);
		
		let resultado = document.querySelector("#resultado");
		
		resultado.innerHTML= "";
		
		for(let item of usuarios){
			
		resultado.innerHTML += `<li>${item.nombres}| ${item.apellidos} | ${item.celular }|${item.contrasena}}</li>`;	
		}
		
		
			
		}
			
	}	
}


	