ALTER TABLE transactions DROP FOREIGN KEY transactions_ibfk_1;
ALTER TABLE limits DROP FOREIGN KEY limits_ibfk_1;
ALTER TABLE transactions CHANGE expense_category_id expense_category enum("product", "service") NOT NULL;
ALTER TABLE limits CHANGE expense_category_id expense_category enum("product", "service") NOT NULL;
DROP TABLE expense_categories;
