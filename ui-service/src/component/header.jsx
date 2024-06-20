import {Button, Menu} from "grommet";

function Header() {
  
    return (
        <Header background="brand">
            <Button  hoverIndicator />
            <Menu label="account" items={[{ label: 'logout' }]} />
        </Header>
    )
}

export default Header;