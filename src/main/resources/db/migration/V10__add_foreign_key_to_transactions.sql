ALTER TABLE transactions ADD COLUMN limit_id BIGINT(10) UNSIGNED NULL;
ALTER TABLE transactions ADD CONSTRAINT fk_limit_id FOREIGN KEY (limit_id) REFERENCES limits(id);