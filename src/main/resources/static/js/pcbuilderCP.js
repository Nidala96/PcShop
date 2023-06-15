//TABELLA CASE PC
document.getElementById("modalNewItemCP").onclick = function()
{
    console.log(document.getElementById("modalNewItemCP"));
	document.getElementById("modal-addCP").style.display = "block";
}

document.getElementById("closeAddCP").onclick = function()
{
	document.getElementById("modal-addCP").style.display = "none";
}

document.getElementById("closeModCP").onclick = function()
{
	document.getElementById("modal-modCP").style.display = "none";
}

window.onclick = function(event)
{
	if(event.target == document.getElementById("modal-modCP"))
	{
		document.getElementById("modal-modCP").style.display = "none";
	}

	if(event.target == document.getElementById("modal-addCP"))
	{
		document.getElementById("modal-addCP").style.display = "none";
	}
}