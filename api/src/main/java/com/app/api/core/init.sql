-- User
INSERT INTO public.users (seq, created_at, updated_at, address, birth_date, email, img, is_use, passworad) VALUES (1, '2020-05-08', '2020-05-08', 'test success', '2020-01-01', 'test@naver.com', 'default.jpg', true, '$2a$10$izMtwwcnfRj4uwfiARXXjOtDl.Tv58Ct9terBiixqKwITCS7aUi2a');

-- Store
INSERT INTO public.stores (seq, created_at, updated_at, address, img, phone, title, user_seq) VALUES (1, '2020-05-09', '2020-05-09', 'test,,,,', 'default', '010-0000-0000', 'test', 1);

-- Product
INSERT INTO public.products (seq, created_at, updated_at, cnt, info, is_sold, price, title, store_seq) VALUES (1, '2020-05-09', '2020-05-16', 10, 'test...', null, 10000.00, 'test', 1);

-- Menu
INSERT INTO public.menus (seq, created_at, updated_at, icon, title, url, menu_order) VALUES (8, '2020-05-08', '2020-05-08',  'faGamepad', 'Controller', '/controller', 8);
INSERT INTO public.menus (seq, created_at, updated_at, icon, title, url, menu_order) VALUES (3, '2020-05-08', '2020-05-08',  'faUsers', 'Users', '/user', 3);
INSERT INTO public.menus (seq, created_at, updated_at, icon, title, url, menu_order) VALUES (6, '2020-05-08', '2020-05-08',  'faListAlt', 'Order', '/order', 6);
INSERT INTO public.menus (seq, created_at, updated_at, icon, title, url, menu_order) VALUES (7, '2020-05-08', '2020-05-08',  'faCog', 'Setting', '/setting', 7);
INSERT INTO public.menus (seq, created_at, updated_at, icon, title, url, menu_order) VALUES (4, '2020-05-08', '2020-05-08',  'faShoppingCart', 'Product', '/product', 4);
INSERT INTO public.menus (seq, created_at, updated_at, icon, title, url, menu_order) VALUES (1, '2020-05-08', '2020-05-08',  'faHome', 'Home', '/home', 1);
INSERT INTO public.menus (seq, created_at, updated_at, icon, title, url, menu_order) VALUES (2, '2020-05-08', '2020-05-08',  'faChartBar', 'Dashboard', '/dashboard', 2);
INSERT INTO public.menus (seq, created_at, updated_at, icon, title, url, menu_order) VALUES (5, '2020-05-08', '2020-05-08',  'faClipboardList', 'Category', '/category', 5);

-- Role
INSERT INTO public.roles (seq, created_at, updated_at, title) VALUES (1, '2020-05-08', '2020-05-08', 'ADMIN');
INSERT INTO public.roles (seq, created_at, updated_at, title) VALUES (2, '2020-05-08', '2020-05-08', 'MANAGER');
INSERT INTO public.roles (seq, created_at, updated_at, title) VALUES (3, '2020-05-08', '2020-05-08', 'USER');

-- URL

INSERT INTO public.urls (seq, created_at, updated_at, title) VALUES (1, '2020-05-09', '2020-05-09', '/hello');
INSERT INTO public.urls (seq, created_at, updated_at, title) VALUES (2, '2020-05-09', '2020-05-09', '/manager/user');
INSERT INTO public.urls (seq, created_at, updated_at, title) VALUES (3, '2020-05-09', '2020-05-09', '/manager/order');
INSERT INTO public.urls (seq, created_at, updated_at, title) VALUES (4, '2020-05-09', '2020-05-09', '/manager/setting');
INSERT INTO public.urls (seq, created_at, updated_at, title) VALUES (5, '2020-05-09', '2020-05-09', '/manager/product');
INSERT INTO public.urls (seq, created_at, updated_at, title) VALUES (7, '2020-05-09', '2020-05-09', '/manager/dashboard');
INSERT INTO public.urls (seq, created_at, updated_at, title) VALUES (8, '2020-05-09', '2020-05-09', '/manager/category');

-- USER ROLE
INSERT INTO public.users_role (seq, created_at, updated_at, role_seq, user_seq) VALUES (1, '2020-05-13', '2020-05-13', 2, 1);
