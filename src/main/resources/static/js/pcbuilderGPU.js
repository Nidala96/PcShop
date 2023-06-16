//TABELLA GPU
document.getElementById("modalNewItemGPU").onclick = function()
{
	document.getElementById("modal-addGPU").style.display = "block";
}

document.getElementById("closeAddGPU").onclick = function()
{
	document.getElementById("modal-addGPU").style.display = "none";
}

document.getElementById("closeModGPU").onclick = function()
{
	document.getElementById("modal-modGPU").style.display = "none";
}

window.onclick = function(event)
{
	if(event.target == document.getElementById("modal-modGPU"))
	{
		document.getElementById("modal-modGPU").style.display = "none";
	}

	if(event.target == document.getElementById("modal-addGPU"))
	{
		document.getElementById("modal-addGPU").style.display = "none";
	}
}



