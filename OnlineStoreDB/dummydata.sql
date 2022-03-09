-- erase ALL existing data
-- DELETE FROM ACTIVE_PRODUCTS
-- DELETE FROM CART
-- DELETE FROM PRODUCT
-- DELETE FROM CATEGORY
--
--  check table values
-- SELECT * FROM CATEGORY
-- SELECT * FROM PRODUCT
-- SELECT * FROM CART
-- SELECT * FROM ACTIVE_PRODUCTS

insert into CATEGORY (CATEGORY_ID,NAME,HEADER_IMAGE) values
    (1, 'laptops', 'laptops.png'),
    (2, 'desktops', 'desktops.png'),
    (3, 'peripherials', 'peripherials.png'),
    (4, 'maker', 'maker.png');

-- laptops
insert into PRODUCT (PRODUCT_ID,NAME,PRICE,IMAGE,DESCRIPTION,CATEGORY_ID) values
    (101, 'Awesome Laptop', 2000, 'awesome-laptop.png', 'It is a really great laptop, trust us.', 1),
    (102, 'Corsage Legendary i10', 100000, 'legendary-i10.png', 'Worth every penny.', 1),
    (103, 'Snapbook Pro', 1700, 'snapbook-pro.png', 'It just works, sometimes.', 1),
    (104, 'Mystery Laptop', 1600, 'mystery-laptop.png', 'Let us choose a laptop for you! No returns.', 1);

-- desktops
insert into PRODUCT (PRODUCT_ID,NAME,PRICE,IMAGE,DESCRIPTION,CATEGORY_ID) values
    (201, 'Lahar Legacy 3', 40000, 'lahar-legacy-3.png', 'Integrated lava cooling system. Not pet safe. Do not ingest.', 2),
    (202, 'Chiptronic Loss Leader 37', 500, 'loss-leader-37.png', 'Remember to buy your peripherials!', 2),
    (203, 'Corsage Legendary c90', 2000, 'legendary-c90.png', 'Elite gaming.', 2);

-- peripherials
insert into PRODUCT (PRODUCT_ID,NAME,PRICE,IMAGE,DESCRIPTION,CATEGORY_ID) values
    (301, 'Chiptronic RGBA Keyboard and Mouse Combo', 2000, 'chiptronic-rgba-combo.png', 'Our LEDs have an alpha channel!', 3),
    (302, 'Chiptronic Basics Keyboard', 500, 'chiptronic-basics-keyboard.png', 'All the keyboard you could want, unless you want more.', 3),
    (303, 'Chiptronic Basics Mouse', 500, 'chiptronic-basics-mouse.png', 'We do not have a wireless version.', 3),
    (304, 'BMX 2380 Graphics Card', 500, 'bmx-2380-graphics-card.png', 'State of the art graphics, at least until you manage to buy one.', 3),
    (305, 'IQ HAL c34-987', 750, 'IQ-HAL-c34-987.png', 'space-age printer technology.', 3);

-- maker
insert into PRODUCT (PRODUCT_ID,NAME,PRICE,IMAGE,DESCRIPTION,CATEGORY_ID) values
    (401, 'Arduo Une', 30, 'arduo-une.png', 'DIY-friendly microcontroller.', 4),
    (402, 'Arduo Deux', 40, 'arduo-deux.png', 'DIY-unfriendly microcontroller.', 4),
    (403, 'LED Rainbow Pack', 10, 'arduo-une.png', 'Have all* the colors! (*six colors included)', 4),
    (404, 'Baling Wire', 30, 'baling-wire.png', 'I think we mixed up the catelogs again.', 4),
    (405, 'Stranded-Core 22AWG Wire', 30, 'stranded-core-22-awg-wire.png', 'Perfect for quick connections.', 4);

insert into CART (CART_ID,BROWSER_INFO) values
    (1,'Chrome 96.0.4664.110 Windows 10 20H2'),
    (2,'Firefox 89.0.238 Windows 10 20H2');

insert into ACTIVE_PRODUCTS (ACTIVE_PRODUCTS_ID,CART_ID,PRODUCT_ID,QUANTITY) values
    (101,1,304,1),
    (201,2,401,1),
    (202,2,402,1),
    (203,2,403,3),
    (204,2,405,2);