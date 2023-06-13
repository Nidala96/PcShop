
function modGioco(element)
{
	document.getElementById("modal-mod").style.display = "block",
	
	document.getElementById("modId").value = element.getAttribute('data-id');
	document.getElementById("modTitolo").value = element.getAttribute('data-titolo');
	document.getElementById("modSupporto").value = element.getAttribute('data-supporto');
	document.getElementById("modCompletato").checked = element.getAttribute('data-completato') === 'true';
	document.getElementById("modAnno").value = element.getAttribute('data-anno');
	document.getElementById("modVoto").value = element.getAttribute('data-voto');
	document.getElementById("modConsole").value = element.getAttribute('data-console');
}