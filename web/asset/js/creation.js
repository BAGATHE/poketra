/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function displaychoice(){
var section = document.querySelector("#para");
section.innerHTML="";
var nom = document.querySelector("#nom").value;
var prix = document.querySelector("#prix").value;

var selectlook = document.querySelector("#look");
var indexlook = selectlook.selectedIndex;
var look = selectlook.options[indexlook].text;

var selecttype = document.querySelector("#type");
var indextype = selecttype.selectedIndex;
var type = selecttype.options[indextype].text;

var taille = document.querySelector("#taille").value;
     
var nompoketra = document.createElement("p");
nompoketra.textContent="nom poketra : " + nom;
 
var prixpoketra = document.createElement("p");
prixpoketra.textContent="prix poketra : " + prix;
 
var lookpoketra = document.createElement("p");
lookpoketra.textContent="look poketra : " + look;
 
var typepoketra = document.createElement("p");
typepoketra.textContent="type poketra : " + type;
 
var taillepoketra = document.createElement("p");
taillepoketra.textContent="taille poketra : " + taille;
 

section.append(nompoketra);
section.append(prixpoketra);
section.append(lookpoketra);
section.append(typepoketra);
section.append(taillepoketra);

 
 
 var checkboxElements = document.querySelectorAll('input[type="checkbox"]');
 var tbody = document.querySelector("#listmateriaux");
 tbody.innerHTML="";
//je boucle le tableau de checkbox et je prend 
  checkboxElements.forEach(checkbox => {
        if (checkbox.checked) {
          var tr = document.createElement("tr");
          var matiere = document.createElement("td");
          var quantiter = document.createElement("td");
          matiere.textContent=document.getElementById(checkbox.value+"-nom").textContent; 
          quantiter.textContent = document.querySelector(`input[name="${checkbox.value}"]`).value;
          
          tr.appendChild(matiere);
          tr.appendChild(quantiter); 
          tbody.append(tr);    
        }
    });   
}










/*etape insertion 
 *insert anaty poketra(idpoketra sequzqnce,idlook,idtype)
 *
 *insert anaty poketramp(idpoketraam,idpoketra,idmatierepremiere,quantiter) //possible ray possible maro b ho any poketra 1
 *
 *insert anaty info poketra
 *
 */ 



