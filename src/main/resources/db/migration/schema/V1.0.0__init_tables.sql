create table role
(
    id                  integer not null,
    name                varchar(50) not null,
    description         varchar(255) null,
    constraint role_pkey primary key (id),
    constraint uk_unique_role_name unique (name)
);

create table "user"
(
    id                  uuid not null,
    username            varchar(255) not null,
    password            varchar(255) not null,
    email               varchar(100) null,
    is_active           boolean default true,
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint user_pkey primary key (id),
    constraint uk_unique_username unique (username),
    constraint uk_unique_email unique (email)
);

create table user_role
(
    user_id     uuid not null,
    role_id     integer not null,
    constraint user_role_pkey primary key (user_id, role_id),
    constraint fk_user_role_role foreign key (role_id) references role (id),
    constraint fk_user_role_user foreign key (user_id) references "user" (id)
);

create table address_type
(
    id                  uuid not null,
    name                varchar(255) not null,
    desciption          varchar(255) null,
    constraint address_type_pkey primary key (id),
    constraint uk_unique_address_type_name unique (name)
);

create table address
(
    id                  uuid not null,
    address_type_id     uuid not null,
    street              varchar(255) not null,
    city                varchar(255) not null,
    state_province      varchar(255) not null,
    postal_code         varchar(255) not null,
    country             varchar(255) not null,
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint address_pkey primary key (id),
    constraint fk_address_address_type foreign key (address_type_id) references address_type(id)
);

create table location
(
    id                  uuid not null,
    name                varchar(255) null,
    description         varchar(255) null,
--    point_geometry GEOMETRY(Point, 4326), -- Represents a point with latitude and longitude (SRID 4326)
--    polygon_geometry GEOMETRY(Polygon, 4326), -- Represents a polygon for areas (SRID 4326)
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint location_pkey primary key (id)
);

create table shop
(
    id                  uuid not null,
    name                varchar(255) not null,
    description         varchar(255) not null,
    address_id          uuid null,
    location_id         uuid null,
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint ship_pkey primary key (id),
    constraint uk_unique_shop_name unique (name),
    constraint fk_shop_location foreign key (location_id) references location(id),
    constraint fk_shop_address foreign key (address_id) references address(id)
);

create table employee
(
    id                  uuid not null,
    shop_id             uuid not null,
    name                varchar(255) not null,
    address_id          uuid null,
    phone_number        varchar(50),
    user_id             uuid not null,
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint employee_pkey primary key (id),
    constraint uk_unique_employee_name unique (name),
    constraint uk_unique_phone_number unique (phone_number),
    constraint fk_employee_address foreign key (address_id) references address(id),
    constraint fk_employee_user foreign key (user_id) references "user" (id)
);

create table score
(
    id                  uuid not null,
    value               int default 0 not null,
    shop_id             uuid not null,
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint score_pkey primary key (id),
    constraint fk_score_shop foreign key (shop_id) references shop(id)
);

create table category
(
    id                  uuid not null,
    name                varchar(255) not null,
    description         varchar(255) null,
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint category_pkey primary key (id),
    constraint uk_unique_category_name unique  (name)
);

create table menu
(
    id                  uuid not null,
    shop_id             uuid not null,
    name                varchar(255) null,
    description         varchar(255) null,
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint menu_pkey primary key (id),
    constraint fk_menu_shop foreign key (shop_id) references shop (id)
);

create table menu_item
(
    id                  uuid not null,
    name                varchar(255) not null,
    description         varchar(255) null,
    price               decimal(10,2) not null,
    menu_id             uuid not null,
    category_id         uuid not null,
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint menu_item_pkey primary key (id),
    constraint uk_unique_menu_item_name unique (name),
    constraint fk_menu_item_category foreign key (category_id) references category (id),
    constraint fk_menu_item_menu foreign key (menu_id) references menu (id)
);

create table payment_method
(
    id              uuid not null,
    name            varchar(255) not null,
    description     varchar(255) not null,
    is_active boolean default true,
    constraint payment_method_pk primary key (id),
    constraint uk_unique_payment_method_name unique (name)
);

create table payment
(
    id                  uuid not null,
    amount              decimal(10,2) not null default 0,
    method_id           uuid not null,
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint payment_pkey primary key (id),
    constraint fk_payment_payment_method foreign key (method_id) references payment_method(id)
);

create table payment_status
(
    id              integer not null,
    name            varchar(255) not null,
    description     varchar(255) null,
    constraint payment_status_pkey primary key(id),
    constraint uk_unique_payment_status_name unique (name)
);

create table customer
(
    id                  uuid not null,
    name                varchar(255) not null,
    phone_number        varchar(50) not null,
    user_id uuid        not null,
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint customer_pk primary key (id),
    constraint fk_customer_user foreign key (user_id) references "user" (id)
);

create table customer_address
(
    customer_id     uuid not null,
    address_id      uuid not null,
    constraint customer_address_pkey primary key (customer_id, address_id),
    constraint fk_customer_address_customer foreign key (customer_id) references customer(id),
    constraint fk_customer_address_address foreign key (address_id) references address(id)
);

create table order_status
(
    id          integer not null,
    name        varchar(255) not null,
    description varchar(255) null,
    constraint order_status_pkey primary key (id),
    constraint uk_unique_order_status_name unique (name)
);

create table "order"
(
    id                  uuid not null,
    customer_id         uuid not null,
    payment_id          uuid not null,
    date                timestamp not null,
    payment_status_id   integer not null,
    order_status_id     integer not null,
    total_price         decimal(10,2) not null default 0,
    total_amount        integer not null default 0,
    shop_id             uuid not null,
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint order_pkey primary key (id),
    constraint uk_unique_order_payment unique (payment_id),
    constraint fk_order_shop foreign key (shop_id) references shop(id),
    constraint fk_order_order_status foreign key (order_status_id) references order_status(id),
    constraint fk_order_payment_status foreign key (payment_status_id) references payment_status(id),
    constraint fk_order_customer foreign key (customer_id) references customer(id)
);

create table order_detail
(
    id uuid not null,
    order_id uuid not null,
    item_id uuid not null,
    price decimal(10,2) null null default 0,
    amount integer not null default 0,
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint order_detail_pkey primary key (id),
    constraint fk_order_detail_order foreign key (order_id) references "order" (id),
    constraint fk_order_detail_menu_item foreign key (item_id) references menu_item(id)
);

create table queue_status
(
    id          integer not null,
    name        varchar(255) not null,
    description varchar(255) not null,
    constraint queue_status_pk primary key (id),
    constraint uk_unique_queue_status_name unique (name)
);

create table queue
(
    id                  uuid not null,
    name                varchar(255) not null,
    description         varchar(255) null,
    queue_status_id              integer not null,
    shop_id uuid        not null,
    created_on          timestamp null,
    created_id          uuid null,
    updated_on          timestamp null,
    updated_id          uuid null,
    deleted_on          timestamp null,
    deleted_id          uuid null,
    constraint queue_pk primary key (id),
    constraint fk_queue_queue_status foreign key (queue_status_id) references queue_status(id)
);

create table queue_order
(
    order_id uuid not null,
    queue_id uuid not null,
    created_on timestamp not null,
    expected_wait_time timestamp not null,
    constraint queue_order_pkey primary key (order_id, queue_id),
    constraint uk_unique_order unique (order_id),
    constraint fk_queue_order_queue foreign key (queue_id) references queue(id),
    constraint fk_queue_order_order foreign key (order_id) references "order"(id)
);


