
CREATE TABLE expense_categories(
    id int auto_increment not null,
    name varchar(255),
    primary key(id)
);
CREATE TABLE currencies(
    id int auto_increment not null,
    name varchar(255),
    primary key(id)
);

CREATE TABLE limits(
    id int auto_increment not null,
    limit_sum double,
    limit_datetime datetime,
    limit_currency_id int,
    primary key(id),
    foreign key(limit_currency_id) references currencies(id)
);

CREATE TABLE transactions(
    id int auto_increment not null,
    account_from int(10),
    account_to int(10),
    currency_id int,
    sum double,
    expense_categories_id int,
    datetime datetime,
    limit_exceeded boolean default 0,
    primary key(id),
    foreign key (currency_id) references currencies(id),
    foreign key (expense_categories_id) references expense_categories(id)
);