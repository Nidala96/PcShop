
document.getElementById("modalNewItemSM").onclick = function()
{
    console.log(document.getElementById("modalNewItemSM"));
	document.getElementById("modal-addSM").style.display = "block";
}

document.getElementById("closeAddSM").onclick = function()
{
	document.getElementById("modal-addSM").style.display = "none";
}

document.getElementById("closeModSM").onclick = function()
{
	document.getElementById("modal-modSM").style.display = "none";
}

window.onclick = function(event)
{
	if(event.target == document.getElementById("modal-modSM"))
	{
		document.getElementById("modal-modSM").style.display = "none";
	}

	if(event.target == document.getElementById("modal-addSM"))
	{
		document.getElementById("modal-addSM").style.display = "none";
	}
}