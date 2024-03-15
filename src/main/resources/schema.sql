SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
        `id` INTEGER NOT NULL AUTO_INCREMENT,
        `name` VARCHAR(250) NOT NULL,
        `slogan` VARCHAR(250) NOT NULL,
        `description` VARCHAR(250) NOT NULL,
        `category` VARCHAR(250) NOT NULL,
        `default_price` INTEGER NOT NULL,
        PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `product_information`;
CREATE TABLE `product_information` (
       `id` INTEGER NOT NULL AUTO_INCREMENT,
       `name` VARCHAR(250) NOT NULL,
       `slogan` VARCHAR(250) NOT NULL,
       `description` VARCHAR(250) NOT NULL,
       `category` VARCHAR(250) NOT NULL ,
       `default_price` INTEGER NOT NULL,
       PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS `features`;
CREATE TABLE `features` (
        `products_id` INTEGER NOT NULL,
        `feature_id` INTEGER NOT NULL AUTO_INCREMENT,
        `feature` VARCHAR(255) NOT NULL,
        `value` VARCHAR(255) NOT NULL,
        PRIMARY KEY (`feature_id`),
        FOREIGN KEY (`products_id`) REFERENCES `product_information`(`id`)
);


DROP TABLE IF EXISTS `styles`;
CREATE TABLE `styles` (
      `style_id` INTEGER NOT NULL AUTO_INCREMENT,
      `product_id` INTEGER NOT NULL,
      `name` VARCHAR(255) NOT NULL,
      `original_price` INTEGER NOT NULL,
      `sale_price` INTEGER NOT NULL,
      `default?` BOOLEAN NOT NULL,
      PRIMARY KEY (`style_id`),
      FOREIGN KEY (`product_id`) REFERENCES `products`(`id`)
);

DROP TABLE IF EXISTS `photos`;
CREATE TABLE `photos` (
      `photos_id` INTEGER NOT NULL AUTO_INCREMENT,
      `style_id` INTEGER NOT NULL,
      `thumbnail_url` VARCHAR(255) NOT NULL,
      `url` VARCHAR(255) NOT NULL,
      PRIMARY KEY (`photos_id`),
      FOREIGN KEY(`style_id`) REFERENCES `styles`(`style_id`)
);

DROP TABLE IF EXISTS `skus`;
CREATE TABLE skus (
      `sku_id` INT NOT NULL PRIMARY KEY,
      `style_id` INT NOT NULL ,
      `quantity` INT NOT NULL ,
      `size` VARCHAR(4) NOT NULL,
      FOREIGN KEY (`style_id`) REFERENCES `styles`(`style_id`)
);

DROP TABLE IF EXISTS `related_products`;
CREATE TABLE `related_products` (
    `id` INTEGER NOT NULL AUTO_INCREMENT,
    `product_id` INTEGER NOT NULL,
    `relatedproduct` INTEGER NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`product_id`) REFERENCES `product information`(`id`)
);
