INSERT INTO `roles` (`id`, `role_name`) VALUES ('1', 'ADMIN');
INSERT INTO `roles` (`id`, `role_name`) VALUES ('2', 'USER');

INSERT INTO `accounts` (`id`, `username`, `email`, `password`, `role_id`)
VALUES ('1', 'adminTest', 'adminTest@gmail.com', 'test10', '1');