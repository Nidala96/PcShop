//Tabella HardDisk
document.getElementById("modalNewItemHDD").addEventListener("click", function()
{
    console.log(document.getElementById("modalNewItemHDD"));
	document.getElementById("modal-addHDD").style.display = "block";
});

document.getElementById("closeAddHDD").addEventListener("click", function()
{
	document.getElementById("modal-addHDD").style.display = "none";
});

window.addEventListener("click", function()
{
	if(event.target == document.getElementById("modal-addHDD"))
	{
		document.getElementById("modal-addHDD").style.display = "none";
	}
});