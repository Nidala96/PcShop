
document.getElementById("modalNewItem").onclick = function()
{
	document.getElementById("modal-add").style.display = "block";
}

document.getElementById("closeAdd").onclick = function()
{
	document.getElementById("modal-add").style.display = "none";
}

document.getElementById("closeMod").onclick = function()
{
	document.getElementById("modal-mod").style.display = "none";
}

window.onclick = function(event)
{
	if(event.target == document.getElementById("modal-mod"))
	{
		document.getElementById("modal-mod").style.display = "none";
	}
	
	if(event.target == document.getElementById("modal-add"))
	{
		document.getElementById("modal-add").style.display = "none";
	}
}