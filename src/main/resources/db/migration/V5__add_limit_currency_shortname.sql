ALTER TABLE limits
ADD COLUMN limit_currency_shortname VARCHAR(3) AFTER expense_category_id;