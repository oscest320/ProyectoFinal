SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';


-- -----------------------------------------------------
-- Table `javageneration`.`proyectos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javageneration`.`proyectos` ;

CREATE  TABLE IF NOT EXISTS `javageneration`.`proyectos` (
  `idproyecto` INT NOT NULL AUTO_INCREMENT ,
  `proyecto` VARCHAR(45) NULL ,
  `fechafin` VARCHAR(45) NULL  ,
  `resumen` VARCHAR(200) NULL ,
  `descripcion` VARCHAR(1024) NULL ,
  `imagen` VARCHAR(128) NULL ,
  `idcliente` INT NULL ,
  
  PRIMARY KEY (`idproyecto`),
  INDEX `cli_fk_clientes` (`idcliente` ASC) ,
   CONSTRAINT `cli_fk_clientes`
    FOREIGN KEY (`idcliente`)
    REFERENCES `javageneration`.`clientes` (`idcliente` )
	ON DELETE SET NULL
    ON UPDATE CASCADE
)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `javageneration`.`clientes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javageneration`.`clientes` ;

CREATE  TABLE IF NOT EXISTS `javageneration`.`clientes` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL ,
  `descripcion` VARCHAR(255) NULL ,
  `logo` VARCHAR(128) NULL ,
  PRIMARY KEY (`idcliente`) 
  )
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
