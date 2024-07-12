function getType(type) {
    switch (type) {
        case 'number':
            return 'Double'
        case 'string':
            return 'String'
        case 'boolean':
            return 'Boolean'
        default:
            return 'Any'
    }
}

function getGlobal() {
    const classes = {}
    const functions = {}
    const properties = {}

    // Get entries
    Object.entries(this).forEach((array) => {
        const name = array[0]
        const object = array[1]
        // Handle entries
        // Generate class or populate it with a function / variable
        switch (typeof object) {
            case 'object':
                const prototype = Object.getPrototypeOf(window.location).constructor.name
                if (!classes.hasOwnProperty(prototype)) {
                    classes[prototype] =
                        `
                            class ${prototype}(private val tag: Tag, private val prefix: String): JsObject(prefix) {
                                override fun toJs(): String = super.toJS("${name}")
                            }
                        `
                }
                break
            case 'function':
                functions[name] =
                `
                    fun JavaScript.${name}(vararg args: Var<*>): Variable<*> {
                        val variables = args.joinToString(", ") { variable -> variable.reference }
                        script.append("${name}(" + variables + ");")
                    }
                    fun JavaScript.${name}(vararg args: Any): Variable<*> {
                        val constants = args.joinToString(", ") { constant -> constant.toString() }
                        script.append("${name}(" + constants + ");")
                    }
                `
                break
            default:
                properties[name] = `val ${name}: Variable<${getType(typeof object)}> = Var(${object});\n`
                break
        }
    })
    return Object.values(classes).join("") + Object.values(functions).join("") + Object.values(properties).join("")
}