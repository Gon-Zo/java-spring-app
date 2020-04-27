// Dto file

/**
 * User Dto
 */
export class UserDto {

    constructor(seq, id, pwd, name, birthDate, address, type, is_use, create_at) {
        this.seq = seq;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.type = type;
        this.is_use = is_use;
        this.create_at = create_at;
    }

    /**
     * isUse
     * @param isUse
     * @returns {string}
     */
    changeIsUser(isUse) {
        return isUse === true ? 'T' : 'F'
    }

}

/**
 * List Dto
 */
export class ListDto {
    constructor(count, numPages, data) {
        this.count = count;
        this.numPages = numPages;
        this.data = data
    }
}

/**
 * Product Dto Class
 */
export class Product {
    constructor(title  = '',
                count = 0,
                price = 0 ,
                info  = '',
                is_sold  = false,
                ) {
        this.title = title;
        this.count = count;
        this.price = price;
        this.info = info;
        this.is_sold = is_sold;
    }

}
