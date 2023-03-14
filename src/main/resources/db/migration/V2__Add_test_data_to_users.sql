INSERT INTO users (id, name, registered_at, is_active, updated_at, version, deleted_at, is_admin, email)
VALUES
(1, 'John Doe', '2022-01-01 10:00:00', true, '2022-01-01 10:00:00', 1, null, true, 'john.doe@example.com'),
(2, 'Jane Doe', '2022-01-02 12:00:00', true, '2022-01-02 12:00:00', 1, null, false, 'jane.doe@example.com'),
(3, 'Bob Smith', '2022-01-03 14:00:00', false, '2022-01-03 14:00:00', 1, null, false, 'bob.smith@example.com'),
(4, 'Alice Brown', '2022-01-04 16:00:00', true, '2022-01-04 16:00:00', 1, null, false, 'alice.brown@example.com'),
(5, 'Tom Jones', '2022-01-05 18:00:00', true, '2022-01-05 18:00:00', 1, null, false, 'tom.jones@example.com');
