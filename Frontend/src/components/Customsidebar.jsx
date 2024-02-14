import { Sidenav, Nav } from "rsuite"; 
import "rsuite/dist/rsuite.min.css"; 
  
function Customsidebar() { 
    return ( 
        <div className="App">  
            <div style={{ width: "200px" }}> 
                <Sidenav appearance="default"> 
                    <Sidenav.Body> 
                        <Nav activeKey="1"> 
                            <Nav.Item eventKey="1"> 
                                Dashboard 
                            </Nav.Item> 
                            <Nav.Menu eventKey="2" title="User"> 
                                <Nav.Item eventKey="2-1"> 
                                    My Profile 
                                </Nav.Item> 
                                <Nav.Item eventKey="2-2"> 
                                    My Articles 
                                </Nav.Item> 
                            </Nav.Menu> 
                        </Nav> 
                    </Sidenav.Body> 
                </Sidenav> 
            </div> 
        </div> 
    ); 
} 
  
export default Customsidebar;