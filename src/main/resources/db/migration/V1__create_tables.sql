
CREATE TABLE expense_categories(
    id int auto_increment not null,
    name varchar(255),
    primary key(id)
);

CREATE TABLE limits(
    id int auto_increment not null,
    limit_sum double,
    limit_datetime datetime,
    expense_category_id int,
    primary key(id),
    foreign key(expense_category_id) references expense_categories(id)
);

CREATE TABLE transactions(
    id int auto_increment not null,
    account_from int(10),
    account_to int(10),
    sum double,
    expense_category_id int,
    datetime datetime,
    limit_exceeded boolean default 0,
    primary key(id),
    foreign key (expense_category_id) references expense_categories(id)
);