//TABELLA RAM
document.getElementById("modalNewItemRAM").onclick = function()
{
    console.log(document.getElementById("modalNewItemRAM"));
	document.getElementById("modal-addRAM").style.display = "block";
}

document.getElementById("closeAddRAM").onclick = function()
{
	document.getElementById("modal-addRAM").style.display = "none";
}

document.getElementById("closeModRAM").onclick = function()
{
	document.getElementById("modal-modRAM").style.display = "none";
}

window.onclick = function(event)
{
	if(event.target == document.getElementById("modal-modRAM"))
	{
		document.getElementById("modal-modRAM").style.display = "none";
	}

	if(event.target == document.getElementById("modal-addRAM"))
	{
		document.getElementById("modal-addRAM").style.display = "none";
	}
}