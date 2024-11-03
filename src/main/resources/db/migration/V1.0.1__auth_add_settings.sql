INSERT INTO `token_settings` (
  `is_active`,
  `token_expiration_days`,
  `refresh_token_expiration_days`,
  `token_type`
) VALUES(1, 1, 0,'VERIFICATION');

INSERT INTO `token_settings` (
    `is_active`,
    `token_expiration_days`,
    `refresh_token_expiration_days`,
    `token_type`
) VALUES(1, 1, 1,'AUTHORIZATION');
