SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';


-- -----------------------------------------------------
-- Table `javageneration`.`mensajes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javageneration`.`mensajes` ;

CREATE  TABLE IF NOT EXISTS `javageneration`.`mensajes` (
  `idmensaje` INT NOT NULL AUTO_INCREMENT,
  `from` VARCHAR(100) NULL ,
  `fecha` TIMESTAMP NULL ,
  `subject` VARCHAR(100) NULL ,
  `mensaje` VARCHAR(512) NULL ,
  `respuesta` VARCHAR(512) NULL ,
  PRIMARY KEY (`idmensaje`) 
  )
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
