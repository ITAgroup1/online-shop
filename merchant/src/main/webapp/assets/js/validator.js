(function (global,factory) {
    factory(global);
})(window,function (win) {

    let Validator = function (config) {
        return new Validator.fn.init(config);
    };

    Validator.fn = Validator.prototype = {
        constructor: Validator
    };

    Validator.prototype.init = function(config){
        this.config = config;
    };

    Validator.prototype.init.prototype = Validator.prototype;

    Validator.fn.validators = {};

    Validator.fn.addValidator = function (validator) {
        this.validators[validator.name] = validator;
    };

    Validator.fn.validateAll = function (data,isBreak) {
        let flag = true;
        for(let field in data){
            let value = data[field];
            if(!this.validate(field,value)){
                flag = false;
                if(isBreak){
                    return flag;
                }
            }
        }
        return flag;
    };

    Validator.fn.validate = function (field,value) {
        let fieldCfg = this.config[field];
        if(fieldCfg && fieldCfg.validators){
            let fieldValidatorsCfg = fieldCfg.validators;
            for(let validatorName in fieldValidatorsCfg){
                let validator = this.validators[validatorName];
                let config = fieldValidatorsCfg[validatorName];

                if(!validator.validate(value,config)){
                    if(config.error){
                        config.error();
                    }
                    return false;
                }
            }
        }
        return true;
    };

    Validator.fn.addValidator({
        name:"length",
        validate: function (val,cfg) {
            if(!val){
                return false;
            }
            let min = cfg.min;
            let max = cfg.max;
            let len = val.length;
            if(min && max){
                if(len < min || len > max){
                    return false;
                }
            }else if(min){
                if(len < min){
                    return false;
                }
            }else if(max){
                if(len > max){
                    return false;
                }
            }
            return true;
        }
    });

    Validator.fn.addValidator({
        name:"regex",
        validate: function (val,cfg) {
            if(!val){
                return false;
            }
            let regex = new RegExp(cfg["regex"]);
            return regex.test(val);
        }
    });


    win.Validator = Validator;
});