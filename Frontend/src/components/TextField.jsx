import PropTypes from 'prop-types'
const TextField = ({type,name})=>{
    return(
        <input type={type} name={name}/>
    )
}
TextField.propTypes={
    type:PropTypes.node.isRequired,
    name:PropTypes.string.isRequired
}
export default TextField;