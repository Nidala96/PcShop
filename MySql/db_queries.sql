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

  select * from hardDisk;
