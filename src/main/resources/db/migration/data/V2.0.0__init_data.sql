-- Sample data for the "user" table
INSERT INTO "user" (id, username, password, email, is_active, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('11111111-1111-1111-1111-111111111111', 'customer1', '123456', 'customer1@example.com', true, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('22222222-2222-2222-2222-222222222222', 'user1', '123456', 'user1@example.com', true, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('33333333-3333-3333-3333-333333333333', 'admin1', '123456', 'admin1@example.com', true, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('44444444-4444-4444-4444-444444444444', 'user2', '123456', 'user2@example.com', true, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('55555555-5555-5555-5555-555555555555', 'user3', '123456', 'user3@example.com', true, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('66666666-6666-6666-6666-666666666666', 'customer2', '123456', 'customer2@example.com', true, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

-- Sample data for the "user_role" table
INSERT INTO user_role (user_id, "role") VALUES
    ('11111111-1111-1111-1111-111111111111', 'ROLE_CUSTOMER'),
    ('66666666-6666-6666-6666-666666666666', 'ROLE_CUSTOMER'),
    ('22222222-2222-2222-2222-222222222222', 'ROLE_USER'),
    ('33333333-3333-3333-3333-333333333333', 'ROLE_ADMIN'),
    ('44444444-4444-4444-4444-444444444444', 'ROLE_USER'),
    ('55555555-5555-5555-5555-555555555555', 'ROLE_USER');

-- Sample data for the "address" table
INSERT INTO address (id, address_type, street, city, state_province, postal_code, country, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('11111111-1111-1111-1111-111111111111', 'HOME', '123 Main St', 'City1', 'State1', '12345', 'Country1', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('22222222-2222-2222-2222-222222222222', 'WORK', '456 Elm St', 'City2', 'State2', '67890', 'Country2', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('33333333-3333-3333-3333-333333333333', 'HOME', '789 Oak St', 'City3', 'State3', '98765', 'Country3', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('44444444-4444-4444-4444-444444444444', 'WORK', '101 Pine St', 'City4', 'State4', '54321', 'Country4', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('55555555-5555-5555-5555-555555555555', 'HOME', '202 Cedar St', 'City5', 'State5', '13579', 'Country5', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

-- Sample data for the "location" table
INSERT INTO location (id, name, description, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('11111111-1111-1111-1111-111111111111', 'Location 1', 'Description for Location 1', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('22222222-2222-2222-2222-222222222222', 'Location 2', 'Description for Location 2', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('33333333-3333-3333-3333-333333333333', 'Location 3', 'Description for Location 3', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('44444444-4444-4444-4444-444444444444', 'Location 4', 'Description for Location 4', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('55555555-5555-5555-5555-555555555555', 'Location 5', 'Description for Location 5', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

-- Sample data for the "shop" table
INSERT INTO shop (id, name, description, address_id, location_id, time_open, time_close, queue_size, queue_amount, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('33333333-3333-3333-3333-333333333333', 'Shop 3', 'Description for Shop 3', '33333333-3333-3333-3333-333333333333', '33333333-3333-3333-3333-333333333333', 8, 20, 50, 1, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

-- Sample data for the "employee" table
INSERT INTO employee (id, shop_id, name, address_id, phone_number, user_id, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('22222222-2222-2222-2222-222222222222', '33333333-3333-3333-3333-333333333333', 'Employee 2', '22222222-2222-2222-2222-222222222222', '987-654-3210', '22222222-2222-2222-2222-222222222222', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('33333333-3333-3333-3333-333333333333', '33333333-3333-3333-3333-333333333333', 'Employee 3', '33333333-3333-3333-3333-333333333333', '333-333-3333', '33333333-3333-3333-3333-333333333333', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('44444444-4444-4444-4444-444444444444', '33333333-3333-3333-3333-333333333333', 'Employee 4', '44444444-4444-4444-4444-444444444444', '111-222-3333', '44444444-4444-4444-4444-444444444444', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('55555555-5555-5555-5555-555555555555', '33333333-3333-3333-3333-333333333333', 'Employee 5', '55555555-5555-5555-5555-555555555555', '555-555-5555', '55555555-5555-5555-5555-555555555555', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

-- Sample data for the "score" table
INSERT INTO score (id, value, shop_id, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('33333333-3333-3333-3333-333333333333', 1, '33333333-3333-3333-3333-333333333333', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

-- Sample data for the "category" table
INSERT INTO category (id, name, description, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('11111111-1111-1111-1111-111111111111', 'Category 1', 'Description for Category 1', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('22222222-2222-2222-2222-222222222222', 'Category 2', 'Description for Category 2', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('33333333-3333-3333-3333-333333333333', 'Category 3', 'Description for Category 3', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('44444444-4444-4444-4444-444444444444', 'Category 4', 'Description for Category 4', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('55555555-5555-5555-5555-555555555555', 'Category 5', 'Description for Category 5', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

-- Sample data for the "menu" table
INSERT INTO menu (id, shop_id, name, description, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('11111111-1111-1111-1111-111111111111', '33333333-3333-3333-3333-333333333333', 'Menu 1', 'Description for Menu 1', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

-- Sample data for the "menu_item" table
INSERT INTO menu_item (id, name, description, price, menu_id, category_id, is_active, time_prepare, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('11111111-1111-1111-1111-111111111111', 'Item 1', 'Description for Item 1', 10000.00, '11111111-1111-1111-1111-111111111111', '11111111-1111-1111-1111-111111111111', true, 10, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('22222222-2222-2222-2222-222222222222', 'Item 2', 'Description for Item 2', 20000.00, '11111111-1111-1111-1111-111111111111', '22222222-2222-2222-2222-222222222222', true, 10, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('33333333-3333-3333-3333-333333333333', 'Item 3', 'Description for Item 3', 30000.00, '11111111-1111-1111-1111-111111111111', '11111111-1111-1111-1111-111111111111', true, 10, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('44444444-4444-4444-4444-444444444444', 'Item 4', 'Description for Item 4', 40000.00, '11111111-1111-1111-1111-111111111111', '22222222-2222-2222-2222-222222222222', true, 10, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('55555555-5555-5555-5555-555555555555', 'Item 5', 'Description for Item 5', 50000.00, '11111111-1111-1111-1111-111111111111', '33333333-3333-3333-3333-333333333333', true, 10, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

-- Sample data for the "payment_method" table
INSERT INTO payment_method (id, name, description, is_active) VALUES
    ('11111111-1111-1111-1111-111111111111', 'Credit Card', 'Payment via credit card', true),
    ('22222222-2222-2222-2222-222222222222', 'Cash', 'Payment by cash', true);

-- Sample data for the "payment" table
INSERT INTO payment (id, amount, status, method_id, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('11111111-1111-1111-1111-111111111111', 300000.00, 'PAID', '22222222-2222-2222-2222-222222222222', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('22222222-2222-2222-2222-222222222222', 300000.00, 'PAID', '22222222-2222-2222-2222-222222222222', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

-- Sample data for the "customer" table
INSERT INTO customer (id, name, phone_number, user_id, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('11111111-1111-1111-1111-111111111111', 'Customer 1', '123-456-7890', '11111111-1111-1111-1111-111111111111', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

-- Sample data for the "customer_address" table
INSERT INTO customer_address (customer_id, address_id) VALUES
    ('11111111-1111-1111-1111-111111111111', '11111111-1111-1111-1111-111111111111');

-- Sample data for the "order" table
INSERT INTO "order" (id, customer_id, payment_id, date, order_status, total_price, total_amount, shop_id, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('11111111-1111-1111-1111-111111111111', '11111111-1111-1111-1111-111111111111', '11111111-1111-1111-1111-111111111111', '2023-09-30 12:00:00', 'DELIVERED', 300000, 9, '33333333-3333-3333-3333-333333333333', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

-- Sample data for the "order_detail" table
INSERT INTO order_detail (id, order_id, item_id, price, amount, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('11111111-1111-1111-1111-111111111111', '11111111-1111-1111-1111-111111111111', '11111111-1111-1111-1111-111111111111', 10000.00, 2, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('22222222-2222-2222-2222-222222222222', '11111111-1111-1111-1111-111111111111', '22222222-2222-2222-2222-222222222222', 20000.00, 1, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('33333333-3333-3333-3333-333333333333', '11111111-1111-1111-1111-111111111111', '33333333-3333-3333-3333-333333333333', 30000.00, 1, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('44444444-4444-4444-4444-444444444444', '11111111-1111-1111-1111-111111111111', '44444444-4444-4444-4444-444444444444', 40000.00, 2, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null),
    ('55555555-5555-5555-5555-555555555555', '11111111-1111-1111-1111-111111111111', '55555555-5555-5555-5555-555555555555', 50000.00, 3, '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

-- Sample data for the "queue" table
INSERT INTO queue (id, name, description, queue_status, shop_id, created_on, created_id, updated_on, updated_id, deleted_on, deleted_id) VALUES
    ('33333333-3333-3333-3333-333333333333', 'Queue 1', 'Description for Queue 1', 'OPEN', '33333333-3333-3333-3333-333333333333', '2023-09-30 00:00:00', null, '2023-09-30 00:00:00', null, null, null);

--INSERT INTO queue_order (order_id, queue_id, created_on, expected_wait_time) VALUES
--    ('22222222-2222-2222-2222-222222222222', '22222222-2222-2222-2222-222222222222', '2023-09-30 00:00:00', '2023-09-30 18:30:00'),
--    ('33333333-3333-3333-3333-333333333333', '33333333-3333-3333-3333-333333333333', '2023-09-30 00:00:00', '2023-09-30 17:15:00'),
--    ('44444444-4444-4444-4444-444444444444', '44444444-4444-4444-4444-444444444444', '2023-09-30 00:00:00', '2023-09-30 16:00:00'),
--    ('55555555-5555-5555-5555-555555555555', '55555555-5555-5555-5555-555555555555', '2023-09-30 00:00:00', '2023-09-30 19:00:00');


