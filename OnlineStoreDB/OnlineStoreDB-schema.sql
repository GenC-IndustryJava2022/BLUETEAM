CREATE TABLE CATEGORY(
CATEGORY_ID int,
NAME varchar(250) not null,
HEADER_IMAGE varchar(250),
primary key (CATEGORY_ID)
);
CREATE TABLE PRODUCT(
PRODUCT_ID int,
NAME varchar(250) not null,
PRICE double not null,
IMAGE varchar(250),
DESCRIPTION varchar(1000),
CATEGORY_ID int,
primary key (PRODUCT_ID),
foreign key (CATEGORY_ID) references CATEGORY(CATEGORY_ID)
);
CREATE TABLE CART(
CART_ID int AUTO_INCREMENT,
BROWSER_INFO varchar(250) not null,
primary key (CART_ID)
);
CREATE TABLE ACTIVE_PRODUCTS(
ACTIVE_PRODUCTS_ID int,
CART_ID int not null,
PRODUCT_ID int not null,
QUANTITY int not null,
primary key (ACTIVE_PRODUCTS_ID),
foreign key (CART_ID) references CART(CART_ID),
foreign key (PRODUCT_ID) references PRODUCT(PRODUCT_ID)
);