-- erase ALL existing data
-- DELETE FROM ACTIVE_PRODUCTS WHERE
-- DELETE FROM CART
-- DELETE FROM PRODUCT
-- DELETE FROM CATEGORY

--  check table values
-- SELECT * FROM CATEGORY
-- SELECT * FROM PRODUCT
-- SELECT * FROM CART
-- SELECT * FROM ACTIVE_PRODUCTS

insert into CATEGORY (CATEGORY_ID,NAME,HEADER_IMAGE) values
    (1, 'laptops', 'laptops.jpg'),
    (2, 'desktops', 'desktops.jpg'),
    (3, 'peripherials', 'peripherials.jpg'),
    (4, 'maker', 'maker.jpg');

-- laptops
insert into PRODUCT (PRODUCT_ID,NAME,PRICE,IMAGE,DESCRIPTION,CATEGORY_ID) values
    (101, 'Awesome Laptop', 2000, '1-awesome-laptop.jpg', 'It is a really great laptop, trust us.', 1),
    (102, 'Corsage Legendary i10', 100000, '1-legendary-i10.jpg', 'Worth every penny.', 1),
    (103, 'Snapbook Pro', 1700, '1-snapbook-pro.jpg', 'It just works, sometimes.', 1),
    (104, 'Mystery Laptop', 1600, '1-mystery-laptop.jpg', 'Let us choose a laptop for you! No returns.', 1);

-- desktops
insert into PRODUCT (PRODUCT_ID,NAME,PRICE,IMAGE,DESCRIPTION,CATEGORY_ID) values
    (201, 'Lahar Legacy 3', 40000, '2-lahar-legacy-3.jpg', 'Integrated lava cooling system. Not pet safe. Do not ingest.', 2),
    (202, 'Chiptronic Loss Leader 37', 500, '2-loss-leader-37.jpg', 'Remember to buy your peripherials!', 2),
    (203, 'Corsage Legendary c90', 2000, '2-legendary-c90.jpg', 'Elite gaming.', 2),
    (204, 'Metapack Unus x8100', 2000, '2-metapack-unus-x8100.jpg', 'All-in-one desktop for the discerning connoisseur.', 2);

-- peripherials
insert into PRODUCT (PRODUCT_ID,NAME,PRICE,IMAGE,DESCRIPTION,CATEGORY_ID) values
    (301, 'Chiptronic RGBA Keyboard and Mouse Combo', 2000, '3-chiptronic-rgba-combo.jpg', 'Our LEDs have an alpha channel!', 3),
    (302, 'Chiptronic Basics Keyboard', 500, '3-chiptronic-basics-keyboard.jpg', 'All the keyboard you could want, unless you want more.', 3),
    (303, 'Chiptronic Basics Mouse', 500, '3-chiptronic-basics-mouse.jpg', 'We do not have a wireless version.', 3),
    (304, 'MSII BMX 2380 Graphics Card', 500, '3-msii-bmx-2380-graphics-card.jpg', 'State of the art graphics, at least until you manage to buy one.', 3),
    (305, 'IQ HAL c34-987', 750, '3-IQ-HAL-c34-987.jpg', 'space-age printer technology.', 3);

-- maker
insert into PRODUCT (PRODUCT_ID,NAME,PRICE,IMAGE,DESCRIPTION,CATEGORY_ID) values
    (401, 'Arduo Une', 30, '4-arduo-une.jpg', 'DIY-friendly microcontroller.', 4),
    (402, 'Arduo Deux', 20, '4-arduo-deux.jpg', 'DIY-unfriendly microcontroller.', 4),
    (403, 'LED Rainbow Pack', 10, '4-led-rainbow-pack.jpg', 'Have all* the colors! (*five colors included)', 4),
    (404, 'RGB LED Strip', 30, '4-rgb-led-strip.jpg', 'Light up your project with LEDs!', 4),
    (405, 'Baling Wire', 25, '4-baling-wire.jpg', 'I think we mixed up the catelogs again.', 4),
    (406, 'Stranded-Core 22AWG Wire', 3, '4-stranded-core-22-awg-wire.jpg', 'Perfect for quick connections.', 4);

insert into CART (CART_ID,BROWSER_INFO) values
    (1,'Chrome 96.0.4664.110 Windows 10 20H2'),
    (2,'Firefox 89.0.238 Windows 10 20H2');

insert into ACTIVE_PRODUCTS (ACTIVE_PRODUCTS_ID,CART_ID,PRODUCT_ID,QUANTITY) values
    (101,1,304,1),
    (201,2,401,1),
    (202,2,402,1),
    (203,2,403,3),
    (204,2,406,2);