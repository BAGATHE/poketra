/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Pc
 * Created: 12 déc. 2023
 */
psql -U postgres
postgresl2

CREATE USER poketra2 WITH PASSWORD 'poketra2';
CREATE DATABASE poketra2;
GRANT ALL PRIVILEGES ON DATABASE poketra2 to poketra2;
CREATE SEQUENCE SeqIdentity increment by 1;

/*TABLE TYPE */
/*formulare*/
CREATE SEQUENCE seqTypePoketra;
CREATE TABLE TypePoketra(
    idTypePoketra VARCHAR(30) PRIMARY KEY,
    nomTypePoketra VARCHAR(30));
/*sac a dos,sac a main,portefeuille*/
/*TABLE LOOK*/
/*formulaire*/
CREATE SEQUENCE seqLookPoketra;
CREATE TABLE LookPoketra(
    idLookPoketra VARCHAR(30) PRIMARY KEY,
    nomLook VARCHAR(30));
/*luxe,normal,debrailler*/

/*TABLE MATIERE PREMIERE*/
/*formulaire*/
CREATE SEQUENCE SeqMatierePremiere;
CREATE TABLE MatierePremiere(
    idMPremiere VARCHAR(20) PRIMARY KEY,
    Materiaux VARCHAR(30),
    prix REAL);

/*atao anaty look matierepremiere ny quantiter*/
/*formulaire*/
INSERT INTO MatierePremiere (Materiaux,prix) VALUES
    ('Cuir', 30000),
    ('Toile',20000),
    ('Polyester',15000),
    ('Nylon',14000),
    ('Coton',12000),
    ('Metal',22000);


CREATE SEQUENCE SeqMatierePremiereEntre;
CREATE TABLE MatierePremiereEntre(
    idMouvementStock VARCHAR(40)PRIMARY KEY,
    idMPremiere VARCHAR(30),
    mouvement numeric,
    dateEntre date default null,
  FOREIGN KEY(idMPremiere) REFERENCES MatierePremiere(idMPremiere));

CREATE SEQUENCE SeqMatierePremiereSortie;
CREATE TABLE MatierePremiereSortie(
    idMouvementStock VARCHAR(40) PRIMARY KEY,
    idMPremiere VARCHAR(30),
    mouvement numeric,
    dateSortie date default null,
  FOREIGN KEY(idMPremiere) REFERENCES MatierePremiere(idMPremiere));


ALTER TABLE MatierePremiereSortie
ALTER COLUMN idmouvementstock TYPE VARCHAR(50);



/*TABLE Poketra */
CREATE SEQUENCE seqPoketra;
CREATE TABLE Poketra(
idPoketra VARCHAR(20) PRIMARY KEY,
idLook VARCHAR(20),
idType VARCHAR(20),
FOREIGN KEY(idLook) REFERENCES LookPoketra(idLookPoketra),
FOREIGN KEY(idType) REFERENCES TypePoketra(idTypePoketra));

/*TABLE INFOPOKETRA*/
CREATE SEQUENCE SeqinfoPoketra;
CREATE TABLE InfoPoketra(
    idInfoPoketra VARCHAR(20) PRIMARY KEY,
    idPoketra VARCHAR(20),
    nom VARCHAR(20),
    types VARCHAR(30),
    look VARCHAR(30),
    taille numeric,
    prix real,
    prixreviens real,
FOREIGN KEY(idPoketra) REFERENCES Poketra(idPoketra));

/*TABLE MANY TO MANY POKETRA & MATIERE PREMIERE*/
CREATE SEQUENCE SeqPoketraMP;
CREATE TABLE PoketraMP(
    idPoketraMP VARCHAR(20) PRIMARY KEY,
    idPoketra VARCHAR(30),
    idMPremiere VARCHAR(30),
    quantite numeric,
    prixTotalMp real,
    FOREIGN KEY(idPoketra) REFERENCES Poketra(idPoketra),
    FOREIGN KEY(idMPremiere) REFERENCES MatierePremiere(idMPremiere));


/*table classe employer*/
CREATE SEQUENCE SeqClasse;
CREATE TABLE ClasseEmployer(
idClasseEmployer serial,
typeclasse VARCHAR(40));
Insert into  ClasseEmployer(idClasseEmployer,typeClasse) VALUES(1,'Ouvrier'),(2,'Senior'),(3,'Expert');

 
CREATE SEQUENCE SeqEmployer;
CREATE TABLE Employer(
    idEmployer VARCHAR(20) PRIMARY KEY,
    roleEmp VARCHAR(50),
    TypeClasse Varchar(50),
    dateEntrer date);

CREATE TABLE Emphierarchie(
idEmphierarchie VARCHAR(40) PRIMARY KEY,
idEmployer VARCHAR(50),
idClasseEmployer numeric default 1,
salaire REAL,
tauxhoraire numeric,
FOREIGN KEY (idEmployer) REFERENCES Employer(idEmployer),
FOREIGN KEY (idClasseEmployer) REFERENCES ClasseEmployer(idClasseEmployer));


CREATE SEQUENCE SeqEmployerPoketra;
CREATE TABLE EmployerPoketra (
    idEmployerPoketra VARCHAR(30) PRIMARY KEY,
    idEmployer VARCHAR(20),
    idPoketra VARCHAR(20),
    nombreEmp numeric,
    heuretravail numeric);






CREATE OR REPLACE VIEW v_poketra_mp AS
SELECT p.idPoketra, p.nom , p.types , p.look , p.taille,p.prix,mp.idmpremiere
FROM InfoPoketra p
JOIN PoketraMP mp ON p.idPoketra = mp.idPoketra;
   

insert into lookpoketra(idlookpoketra,nomlook) value('lookpoketra-1','normal'),('lookpoketra-3','debrailler'),('lookpoketra-2','luxe');

insert into lookpoketra(idlookpoketra,nomlook) values ('lookpoketra-3','debrailler');



CREATE OR REPLACE VIEW v_stock_entrer AS SELECT idMPremiere, SUM(Mouvement) as quantiterEntrer FROM  MatierePremiereEntre GROUP BY idMPremiere;

CREATE OR REPLACE VIEW v_stock_sortie AS 
SELECT idMPremiere, SUM(Mouvement) as quantiterSortie FROM  MatierePremiereSortie GROUP BY idMPremiere;


CREATE OR REPLACE VIEW v_etat_stock AS SELECT se.idMPremiere AS idMPremiere,(se.quantiterEntrer - ss.quantiterSortie) AS enstock 
FROM v_stock_entrer se 
JOIN v_stock_sortie ss on se.idMPremiere = ss.idMPremiere;




CREATE OR REPLACE VIEW v_etat_stock_detail AS
SELECT mp.idMPremiere, mp.Materiaux, mp.prix,
       (v_mpe.quantiterEntrer - v_mps.quantiterSortie) AS quantiterstock
FROM MatierePremiere mp
JOIN v_stock_entrer v_mpe ON mp.idMPremiere = v_mpe.idMPremiere
JOIN v_stock_sortie v_mps ON mp.idMPremiere = v_mps.idMPremiere;



CREATE OR REPLACE VIEW v_temps_de_travail AS
SELECT idEmployer ,
       classe ,
       EXTRACT(YEAR FROM AGE(NOW(), dateEntrer)) -
       CASE WHEN EXTRACT(MONTH FROM dateEntrer) > EXTRACT(MONTH FROM NOW())
            OR (EXTRACT(MONTH FROM dateEntrer) = EXTRACT(MONTH FROM NOW()) AND EXTRACT(DAY FROM dateEntrer) > EXTRACT(DAY FROM NOW()))
           THEN 1
           ELSE 0
       END AS tempsTravail,
       roleEmp
FROM Employer emp

