function modConsole(element) 
{
	document.getElementById("modal-mod").style.display = "block";
	
	document.getElementById("modId").value=element.getAttribute('data-id');
	document.getElementById("modNome").value=element.getAttribute('data-nome');
	document.getElementById("modProduttore").value=element.getAttribute('data-produttore');
	document.getElementById("modNazione").value=element.getAttribute('data-nazione');
}
