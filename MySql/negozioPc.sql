create database negozioPc;
use negozioPc;
 -- drop database negozioPc;

create table processore (
id int primary key auto_increment,
nome varchar(100),
marca varchar(100),
prezzo double,
descrizione varchar(100)
);

create table gpu(
id int primary key auto_increment,
nome varchar(100),
prezzo double,
descrizione varchar(100)
);

create table schedaMadre(
id int primary key auto_increment,
nome varchar(100),
supporto varchar(100),
prezzo double,
descrizione varchar(100)
);

create table casePc(
id int primary key auto_increment,
nome varchar(100),
prezzo double,
descrizione varchar(100)
);

drop table pc;

CREATE TABLE pc (
  id int primary key auto_increment,
  nome varchar(100),
  tipo varchar(100),
  percentualeSconto double,
  processore_id int,
  gpu_id int,
  schedaMadre_id int,
  casePc_id int,
  ram_id INT,
  hardDisk_id INT,
  foreign key (processore_id) references processore(id),
  foreign key (gpu_id) references gpu(id),
  foreign key (schedaMadre_id) references schedaMadre(id),
  foreign key (casePc_id) references casePc(id),
  FOREIGN KEY (ram_id) REFERENCES ram(id),
  FOREIGN KEY (hardDisk_id) REFERENCES hardDisk(id)
);

create table ram (
  id int primary key auto_increment,
  nome varchar(100),
  tipo varchar(50),
  quantita int,
  prezzo double,
  descrizione varchar(100),
  frequenza varchar(20)
);

create table hardDisk(
id int primary key auto_increment,
nome varchar(100),
tipo varchar(100),
quantitaMem int,
descrizione varchar(100),
prezzo double
);

INSERT INTO processore (nome, marca, prezzo, descrizione)
VALUES 
  ('Intel Core i9-9900K', 'Intel', 549.99, 'Processore octa-core ad alte prestazioni'),
  ('AMD Ryzen 7 3700X', 'AMD', 329.99, 'Processore octa-core con prestazioni eccezionali'),
  ('Intel Core i5-9600K', 'Intel', 269.99, 'Processore hexa-core per giochi e applicazioni'),
  ('AMD Ryzen 5 3600X', 'AMD', 249.99, 'Processore hexa-core ad alte prestazioni'),
  ('Intel Core i7-10700K', 'Intel', 399.99, 'Processore octa-core per gaming e creazione di contenuti'),
  ('AMD Ryzen 9 3900X', 'AMD', 499.99, 'Processore dodeca-core con prestazioni di livello enthusiast'),
  ('Intel Core i7-11700K', 'Intel', 499.99, 'Processore octa-core di ultima generazione'),
  ('AMD Ryzen 7 5800X', 'AMD', 449.99, 'Processore octa-core per prestazioni di alto livello'),
  ('Intel Core i9-11900K', 'Intel', 649.99, 'Processore octa-core di fascia alta per gaming e applicazioni intensive'),
  ('AMD Ryzen 9 5950X', 'AMD', 799.99, 'Processore dodeca-core di massima potenza'),
  ('Intel Core i7-9700K', 'Intel', 399.99, 'Processore octa-core per prestazioni elevate'),
  ('AMD Ryzen 7 3700', 'AMD', 279.99, 'Processore octa-core ad alte prestazioni');

INSERT INTO gpu (nome, prezzo, descrizione)
VALUES
  ('NVIDIA GeForce RTX 3080', 799.99, 'GPU di fascia alta per prestazioni di gioco estreme'),
  ('AMD Radeon RX 6900 XT', 999.99, 'GPU di punta per gaming e rendering professionale'),
  ('NVIDIA GeForce RTX 3070', 499.99, 'GPU di fascia alta per esperienze di gioco fluide'),
  ('AMD Radeon RX 6800 XT', 649.99, 'GPU per gaming ad alte prestazioni e rendering 3D'),
  ('NVIDIA GeForce RTX 3060', 329.99, 'GPU di fascia media per esperienze di gioco solide'),
  ('AMD Radeon RX 6700 XT', 479.99, 'GPU per gaming ad alte prestazioni a risoluzioni 1440p'),
  ('NVIDIA GeForce RTX 3090', 1499.99, 'GPU di fascia estrema per gaming e creazione di contenuti'),
  ('AMD Radeon RX 6600 XT', 379.99, 'GPU di fascia media per gaming di qualità'),
  ('NVIDIA GeForce RTX 2080 Ti', 1099.99, 'GPU di fascia alta per esperienze di gioco avanzate'),
  ('AMD Radeon RX 5700 XT', 449.99, 'GPU ad alte prestazioni per gaming fluido'),
  ('NVIDIA GeForce GTX 1660 Super', 249.99, 'GPU di fascia media per gaming a 1080p'),
  ('AMD Radeon RX 5600 XT', 329.99, 'GPU per gaming a 1080p ad alte prestazioni'),
  ('NVIDIA GeForce GTX 1650 Super', 199.99, 'GPU di fascia media per gaming a 1080p'),
  ('AMD Radeon RX 5500 XT', 249.99, 'GPU per gaming a 1080p di buona qualità'),
  ('NVIDIA GeForce GT 1030', 89.99, 'GPU entry-level per uso generale e gaming leggero'),
  ('AMD Radeon RX 540', 79.99, 'GPU entry-level per uso generale e video in streaming'),
  ('NVIDIA GeForce MX350', 149.99, 'GPU per notebook leggeri e multitasking'),
  ('AMD Radeon Pro WX 7100', 599.99, 'GPU professionale per workstation e rendering 3D'),
  ('NVIDIA Quadro P4000', 899.99, 'GPU professionale per workstation e modellazione CAD'),
  ('AMD Radeon Pro WX 5100', 399.99, 'GPU professionale per workstation e progettazione 3D');

INSERT INTO schedaMadre (nome, supporto, prezzo, descrizione)
VALUES
  ('MSI B450 TOMAHAWK MAX', 'AMD', 139.99, 'Scheda madre ATX per processori AMD'),
  ('ASUS ROG Strix Z490-E Gaming', 'Intel', 299.99, 'Scheda madre ATX per processori Intel'),
  ('GIGABYTE B550 AORUS Elite', 'AMD', 159.99, 'Scheda madre ATX per processori AMD Ryzen'),
  ('MSI MPG Z590 Gaming Edge WIFI', 'Intel', 249.99, 'Scheda madre ATX per processori Intel Core di 11a generazione'),
  ('ASRock B550M PRO4', 'AMD', 99.99, 'Scheda madre Micro ATX per processori AMD Ryzen'),
  ('ASUS TUF Gaming B550-PLUS', 'AMD', 169.99, 'Scheda madre ATX per processori AMD Ryzen di 3a generazione'),
  ('GIGABYTE X570 AORUS Elite', 'AMD', 199.99, 'Scheda madre ATX per processori AMD Ryzen di 3a generazione'),
  ('MSI MAG B550 TOMAHAWK', 'AMD', 179.99, 'Scheda madre ATX per processori AMD Ryzen di 3a generazione'),
  ('ASUS ROG Maximus XIII Hero', 'Intel', 549.99, 'Scheda madre ATX per processori Intel Core di 11a generazione'),
  ('GIGABYTE Z590 AORUS Master', 'Intel', 449.99, 'Scheda madre ATX per processori Intel Core di 11a generazione'),
  ('ASRock B450M Steel Legend', 'AMD', 109.99, 'Scheda madre Micro ATX per processori AMD Ryzen'),
  ('MSI MPG B550 Gaming Plus', 'AMD', 149.99, 'Scheda madre ATX per processori AMD Ryzen di 3a generazione'),
  ('ASUS PRIME Z490-A', 'Intel', 279.99, 'Scheda madre ATX per processori Intel Core di 10a e 11a generazione'),
  ('GIGABYTE B450 AORUS Elite', 'AMD', 119.99, 'Scheda madre ATX per processori AMD Ryzen'),
  ('MSI MAG X570 TOMAHAWK WIFI', 'AMD', 249.99, 'Scheda madre ATX per processori AMD Ryzen di 3a generazione'),
  ('ASUS ROG Strix B550-F Gaming', 'AMD', 189.99, 'Scheda madre ATX per processori AMD Ryzen di 3a generazione'),
  ('GIGABYTE B450M DS3H', 'AMD', 74.99, 'Scheda madre Micro ATX per processori AMD Ryzen'),
  ('ASRock Z590 Extreme WiFi 6E', 'Intel', 329.99, 'Scheda madre ATX per processori Intel Core di 11a generazione');

INSERT INTO casePc (nome, prezzo, descrizione)
VALUES
  ('NZXT H510', 79.99, 'Case di fascia media con design elegante e funzionalità avanzate'),
  ('Corsair iCUE 4000X RGB', 129.99, 'Case ATX con pannello in vetro temperato e illuminazione RGB'),
  ('Fractal Design Meshify C', 89.99, 'Case compatto con elevata capacità di ventilazione'),
  ('Phanteks Eclipse P400A', 99.99, 'Case con ampia ventilazione e supporto per radiatori'),
  ('Cooler Master MasterBox Q300L', 49.99, 'Case Micro ATX compatto e versatile'),
  ('Lian Li PC-O11 Dynamic', 149.99, 'Case ATX con design moderno e vetro temperato'),
  ('NZXT H710i', 169.99, 'Case di fascia alta con ampio spazio interno e gestione dei cavi'),
  ('Corsair Carbide 275R', 69.99, 'Case ATX con design minimalista e buona ventilazione'),
  ('Phanteks Eclipse P500A', 149.99, 'Case con elevata capacità di raffreddamento e spazio per componenti'),
  ('Fractal Design Define 7', 169.99, 'Case ATX con isolamento acustico e funzionalità di gestione dei cavi'),
  ('Cooler Master MasterCase H500', 99.99, 'Case ATX con pannello frontale in mesh per una migliore ventilazione'),
  ('Lian Li PC-O11 Dynamic XL', 199.99, 'Case di fascia alta con ampio spazio per il raffreddamento a liquido'),
  ('NZXT H510 Elite', 149.99, 'Case di fascia media con pannello frontale in vetro temperato e illuminazione RGB'),
  ('Corsair Crystal 570X RGB', 179.99, 'Case ATX con pannello in vetro temperato e illuminazione RGB'),
  ('Phanteks Enthoo Pro II', 129.99, 'Case ATX con ampio spazio interno e possibilità di personalizzazione'),
  ('Fractal Design Meshify S2', 149.99, 'Case ATX con design compatto e ottime capacità di raffreddamento'),
  ('Cooler Master MasterCase H500M', 199.99, 'Case ATX con pannello frontale in mesh e illuminazione RGB'),
  ('Lian Li PC-O11D XL ROG Edition', 249.99, 'Case di fascia alta in edizione speciale per ASUS ROG'),
  ('NZXT H710', 149.99, 'Case di fascia alta con ampio spazio interno e possibilità di gestione avanzata dei cavi'),
  ('Corsair Obsidian 500D RGB SE', 249.99, 'Case di fascia alta con design elegante e illuminazione RGB');
  
  INSERT INTO pc (nome, tipo, percentualeSconto, processore_id, gpu_id, schedaMadre_id, casePc_id, ram_id, hardDisk_id)
	VALUES
  ('PC Gaming','gaming', 1, 8, 12, 4, 7, 6, 4),
  ('PC Ufficio', 'ufficio', 1, 2, 9, 6, 10, 6, 4),
  ('PC Gaming', 'gaming',  1, 11, 18, 1, 14, 6, 4),
  ('PC Ufficio','ufficio', 1, 3, 10, 5, 12, 6, 4),
  ('PC Gaming','gaming', 1, 11, 7, 11, 11, 6, 4),
  ('PC Ufficio','ufficio',1, 4, 5, 8, 3, 6, 4),
  ('PC Gaming','gaming',1, 9, 16, 2, 9, 6, 4),
  ('PC Ufficio','ufficio',1, 6, 14, 11, 5, 6, 4),
  ('PC Gaming','gaming', 1,1, 3, 10, 6, 6, 4),
  ('PC Ufficio','ufficio', 1,1, 8, 7, 2, 6, 4);
  
  INSERT INTO pc (nome, tipo, percentualeSconto, processore_id, gpu_id, schedaMadre_id, casePc_id, ram_id, hardDisk_id)
VALUES
  ('PC Gaming', 'gaming', 1, 8, 12, 4, 7, 6, 1),
  ('PC Ufficio', 'ufficio', 1, 2, 9, 6, 10, 9, 2),
  ('PC Gaming', 'gaming', 1, 11, 15, 1, 14, 7, 3),
  ('PC Ufficio', 'ufficio', 1, 3, 10, 5, 12, 11, 4),
  ('PC Gaming', 'gaming', 1, 11, 7, 11, 11, 5, 5),
  ('PC Ufficio', 'ufficio', 1, 4, 5, 8, 3, 6, 6),
  ('PC Gaming', 'gaming', 1, 9, 15, 2, 9, 6, 7),
  ('PC Ufficio', 'ufficio', 1, 6, 14, 11, 5, 3, 8),
  ('PC Gaming', 'gaming', 1, 1, 3, 10, 6, 6, 9),
  ('PC Ufficio', 'ufficio', 1, 1, 8, 7, 2, 6, 10),
  ('PC Gaming', 'gaming', 1, 8, 12, 4, 7, 6, 11),
  ('PC Ufficio', 'ufficio', 1, 2, 9, 6, 10, 8, 12),
  ('PC Gaming', 'gaming', 1, 11, 15, 1, 14, 3, 13),
  ('PC Ufficio', 'ufficio', 1, 3, 10, 5, 12, 5, 14),
  ('PC Gaming', 'gaming', 1, 11, 7, 11, 11, 1, 15),
  ('PC Ufficio', 'ufficio', 1, 4, 5, 8, 3, 4, 16),
  ('PC Gaming', 'gaming', 1, 9, 15, 2, 9, 1, 17),
  ('PC Ufficio', 'ufficio', 1, 6, 14, 11, 5, 9, 18),
  ('PC Gaming', 'gaming', 1, 1, 3, 10, 6, 3, 19),
  ('PC Ufficio', 'ufficio', 1, 1, 8, 7, 2, 4, 20);


select * from pc;
  
  select * from utenti;
  select * from processore;
  
  select * from gpu;
  
  select * from ram;
  
  select * from schedaMadre;
  
  select * from casePc;
  
  SELECT pc.nome AS pc_nome, pc.tipo AS pc_tipo,
  processore.nome AS processore_nome, processore.marca AS processore_marca, processore.prezzo AS processore_prezzo,
  gpu.nome AS gpu_nome, gpu.prezzo AS gpu_prezzo,
  schedaMadre.nome AS schedaMadre_nome, schedaMadre.supporto AS schedaMadre_supporto, schedaMadre.prezzo AS schedaMadre_prezzo,
  casePc.nome AS casePc_nome, casePc.prezzo AS casePc_prezzo
FROM pc
INNER JOIN processore ON pc.processore_id = processore.id
INNER JOIN gpu ON pc.gpu_id = gpu.id
INNER JOIN schedaMadre ON pc.schedaMadre_id = schedaMadre.id
INNER JOIN casePc ON pc.casePc_id = casePc.id;

create table utenti
(
	id int primary key auto_increment,
    nome varchar(100),
    cognome varchar(100),
    username varchar(100),
    password varchar(100),
    ruolo varchar(100)
);

insert into utenti
(nome,cognome,username,password,ruolo)
values("Mario","Rossi","admin","admin","amministratore"),("Mara","Bianchi","mb","marabianchi","visitatore");

INSERT INTO ram (nome, tipo, quantita, prezzo, descrizione, frequenza)
VALUES
  ('Corsair Vengeance LPX', 'DDR4', 16, 89.99, 'Kit di memoria ad alte prestazioni per PC desktop', '3200 MHz'),
  ('G.Skill Ripjaws V', 'DDR4', 32, 169.99, 'Memoria ad alte prestazioni per gaming e multitasking', '3600 MHz'),
  ('Crucial Ballistix RGB', 'DDR4', 16, 99.99, 'RAM con effetti di illuminazione RGB personalizzabili', '3200 MHz'),
  ('Kingston HyperX Fury', 'DDR4', 8, 49.99, 'Memoria ad alta velocità per gaming e produttività', '2666 MHz'),
  ('Team T-Force Delta RGB', 'DDR4', 32, 159.99, 'RAM con illuminazione RGB vivace e design unico', '3200 MHz'),
  ('Corsair Dominator Platinum RGB', 'DDR4', 32, 219.99, 'Memoria premium con illuminazione RGB personalizzabile', '3600 MHz'),
  ('Crucial Ballistix MAX', 'DDR4', 64, 299.99, 'RAM ad alte prestazioni per gaming e applicazioni intensive', '4000 MHz'),
  ('G.Skill Trident Z Neo', 'DDR4', 32, 189.99, 'Memoria RAM con effetti di illuminazione RGB accattivanti', '3600 MHz'),
  ('Corsair Vengeance RGB Pro', 'DDR4', 16, 119.99, 'RAM con effetti di illuminazione RGB vivaci e personalizzabili', '3200 MHz'),
  ('Kingston HyperX Predator', 'DDR4', 64, 349.99, 'Memoria ad alte prestazioni per gaming e creazione di contenuti', '3200 MHz'),
  ('Crucial Ballistix Elite', 'DDR4', 32, 199.99, 'RAM ad alte prestazioni per overclocking e gaming estremo', '3600 MHz'),
  ('Corsair Vengeance LPX', 'DDR4', 8, 69.99, 'Memoria RAM ad alte prestazioni per PC desktop', '2400 MHz'),
  ('G.Skill Trident Z Royal', 'DDR4', 16, 139.99, 'RAM con design lussuoso e prestazioni elevate', '3200 MHz'),
  ('Corsair Dominator Platinum', 'DDR4', 32, 229.99, 'Memoria RAM premium per prestazioni estreme', '3600 MHz'),
  ('Kingston HyperX Fury RGB', 'DDR4', 16, 109.99, 'RAM con effetti di illuminazione RGB vivaci', '3200 MHz'),
  ('Crucial Ballistix Sport LT', 'DDR4', 16, 79.99, 'RAM ad alte prestazioni per gaming e multitasking', '3000 MHz'),
  ('G.Skill Trident Z', 'DDR4', 32, 179.99, 'Memoria RAM con design elegante e prestazioni elevate', '3200 MHz'),
  ('Corsair Vengeance RGB Pro SL', 'DDR4', 32, 199.99, 'RAM con effetti di illuminazione RGB vivaci e profilo sottile', '3200 MHz'),
('Kingston HyperX Impact', 'DDR4', 16, 259.90, 'Memoria RAM ad alta velocità per notebook e mini PC', '2666 MHz'),
  ('Crucial Ballistix Gaming', 'DDR4', 32, 158.90, 'RAM ad alte prestazioni per gaming e multitasking', '3200 MHz');
  
INSERT INTO hardDisk (nome, tipo, quantitaMem, descrizione, prezzo)
VALUES
  ('Seagate Barracuda', 'HDD', 2000, 'Hard disk interno da 2 TB per archiviazione dati', 79.99),
  ('Western Digital Blue', 'HDD', 1000, 'Hard disk interno da 1 TB per PC desktop', 49.99),
  ('Samsung 970 EVO Plus', 'SSD', 500, 'Solid state drive NVMe da 500 GB per prestazioni elevate', 109.99),
  ('Crucial MX500', 'SSD', 1000, 'Solid state drive SATA da 1 TB per velocità e affidabilità', 89.99),
  ('Seagate IronWolf', 'HDD', 4000, 'Hard disk interno da 4 TB per NAS e server domestici', 129.99),
  ('Samsung 870 EVO', 'SSD', 2000, 'Solid state drive SATA da 2 TB per velocità e resistenza', 179.99),
  ('Western Digital Black', 'HDD', 6000, 'Hard disk interno da 6 TB per prestazioni estreme', 189.99),
  ('Crucial P5', 'SSD', 100, 'Solid state drive NVMe da 1 TB per gaming e creazione di contenuti', 149.99),
  ('Seagate FireCuda', 'SSHD', 2000, 'Unità ibrida da 2 TB con prestazioni SSD e capacità HDD', 89.99),
  ('Western Digital My Passport', 'External HDD', 4000, 'Hard disk esterno da 4 TB per backup e archiviazione portatile', 119.99),
  ('Samsung T7', 'External SSD', 1000, 'Solid state drive esterno da 1 TB con connessione USB 3.2 Gen 2', 169.99),
  ('Seagate Backup Plus Hub', 'External HDD', 8000, 'Hard disk esterno da 8 TB con porte USB integrate', 249.99),
  ('Crucial X8', 'External SSD', 2000, 'Solid state drive esterno da 2 TB resistente e veloce', 199.99),
  ('Western Digital Elements', 'External HDD', 1000, 'Hard disk esterno da 1 TB con connessione USB 3.0', 59.99),
  ('Samsung X5', 'External SSD', 1000, 'Solid state drive esterno Thunderbolt 3 da 1 TB per velocità estreme', 399.99),
  ('Seagate Expansion', 'External HDD', 5000, 'Hard disk esterno da 5 TB per archiviazione di grandi dimensioni', 149.99),
  ('Crucial X6', 'External SSD', 500, 'Solid state drive esterno da 500 GB compatto e leggero', 79.99),
  ('Western Digital My Book', 'External HDD', 10000, 'Hard disk esterno da 10 TB per archiviazione desktop', 249.99),
  ('Samsung T5', 'External SSD', 500, 'Solid state drive esterno da 500 GB con connessione USB 3.1', 119.99),
  ('Seagate Game Drive', 'External HDD', 2000, 'Hard disk esterno da 2 TB per console di gioco', 299.90),
  ('Crucial BX500', 'SSD', 240, 'Solid state drive SATA da 240 GB per migliorare le prestazioni del sistema', 189.90);
  
  select * from hardDisk;
