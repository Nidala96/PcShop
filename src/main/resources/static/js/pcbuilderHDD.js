//Tabella HardDisk
document.getElementById("modalNewItemHDD").onclick = function()
{
    console.log(document.getElementById("modalNewItemHDD"));
	document.getElementById("modal-addHDD").style.display = "block";
}

document.getElementById("closeAddHDD").onclick = function()
{
	document.getElementById("modal-addHDD").style.display = "none";
}

document.getElementById("closeModHDD").onclick = function()
{
	document.getElementById("modal-modHDD").style.display = "none";
}

window.onclick = function(event)
{
	if(event.target == document.getElementById("modal-modHDD"))
	{
		document.getElementById("modal-modHDD").style.display = "none";
	}

	if(event.target == document.getElementById("modal-addHDD"))
	{
		document.getElementById("modal-addHDD").style.display = "none";
	}
}