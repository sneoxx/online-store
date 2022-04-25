CREATE TABLE goods (
	goods_id uuid NOT NULL,
	goods_name varchar(50) NOT NULL,
	goods_description varchar(200) NOT NULL,
	goods_price varchar(10) NOT NULL,
	creation_date varchar(20) NOT NULL,
	update_date timestamp,
	CONSTRAINT goods_pkey PRIMARY KEY (goods_id)
);


INSERT INTO client(goods_id, goods_name, goods_description, goods_price, creation_date, update_date) VALUES
(uuid(),'Goods1','Goods1 Description','1$',now()::timestamp),
(uuid(),'Goods2','Goods2 Description','2$',now()::timestamp),
(uuid(),'Goods3','Goods3 Description','3$',now()::timestamp);
