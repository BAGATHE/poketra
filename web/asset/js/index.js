var btnforms = document.querySelectorAll("button");

btnforms.forEach(button => {
    button.addEventListener("click", () => {
        // Masquer toutes les div
        var allDivs = document.querySelectorAll(".insert");
        allDivs.forEach(div => {
            div.style.display = 'none';
        });

        // Afficher uniquement la div correspondant au bouton cliqué
        var name = button.name;
        var div = document.getElementById(name);
        div.style.display = 'flex'; 
    });
});


