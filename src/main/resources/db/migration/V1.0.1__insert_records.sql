INSERT INTO books (id, title, author, published)
VALUES (1, 'hello kotlin', 'mike', '2021-11-18'),
       (2, 'hello java', 'popcorn', '2021-11-18');

-- plain text password is `1qaazxsw2`
-- @see com/kiyotakeshi/library/PasswordEncodingTest.kt
INSERT INTO users (id, email, password, name, role_type)
VALUES (1, 'test@example.com', '$2a$10$dxKi.R0LKtFufMdeEmn/YuFRSQn3gSk702mTevwLUm2wfseL6GBha', 'test', 'ROLE_ADMIN'),
       (2, 'test2@example.com', '$2a$10$j9sEloPYemJ/sMvoHeQFnevZhrqxNfA5vJqA0gFlOUp/EoXOQEu12', 'test2', 'ROLE_USER');
