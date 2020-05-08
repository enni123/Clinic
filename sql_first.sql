SELECT * FROM mastermix.shop;
update shop set price=13.4 where article=0001;
alter table shop add column dee double(10,0);
update shop set ppk=10.13 where article=0003;
insert into shop (article, dealer, price, set_shop, ppk, dee) values(0005, 'HV', 45.77, null, 55.90, 42.18);
update shop set price=10.13 where article=0001;