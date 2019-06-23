package pizzaloop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@RequestMapping(path="/system")
public class MainController {
    private static int mobileStatus = 1;
    private static int emailStatus = 1;
    private static String success = "";
    //java -jar mysql-rest-service-1.0-SNAPSHOT.jar

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private HotPizzaRepository hotPizzaRepository;
    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private UserRepository userRepository;


    @GetMapping(path="/getAllHotProducts")
    public @ResponseBody Iterable<HotPizzaDetails> getHotPizzaDetails() {
        return hotPizzaRepository.findAll();
    }

    @GetMapping(path="/getAllCartDetails")
    public @ResponseBody Iterable<CartDetails> getCartDetails() {
        return cartRepository.findAll();
    }

    @GetMapping(path="/getAllProducts")
    public @ResponseBody Iterable<PizzaDetails> getPizzaDetails() {
        return pizzaRepository.findAll();
    }


    @GetMapping(path="/getAllUsers")
    public @ResponseBody Iterable<UserDetails> getUserDetails() {
        return userRepository.findAll();
    }

    @GetMapping(path="/findByPizzaId")
    public @ResponseBody List<PizzaDetails> getPizzaById(@RequestParam int id) {
        return pizzaRepository.findByPizzaId(id);
    }

    @GetMapping(path="/findByCustomerId")
    public @ResponseBody List<CartDetails> getCartDetailsById(@RequestParam int id) {
        return cartRepository.findByCustomerId(id);
    }

    public static String name;
    @GetMapping(path="/findByUserId")
    public @ResponseBody String getUserById(@RequestParam int id) {
        Iterable<UserDetails> i = userRepository.findByUserId(id);
        for(UserDetails p: i) {
            name = p.getName();
        }
        return name;
    }

    @GetMapping(path="/addToCart")
    public @ResponseBody String addToCart(@RequestParam int customerId,@RequestParam String itemName,@RequestParam Double lat,@RequestParam Double lon,@RequestParam int itemQuantity,@RequestParam Double itemTotal) {
        System.out.println("CustomerId = "+customerId+"Item Name ="+itemName+"Lat ="+lat+"Lon ="+lon+"Item Quantity ="+itemQuantity+"Item total ="+itemTotal);
        CartDetails cartDetails = new CartDetails();
        cartDetails.setCustomerId(customerId);
        cartDetails.setItemName(itemName);
        cartDetails.setLocationLatitude(lat);
        cartDetails.setLocationLongitude(lon);
        cartDetails.setItemQuantity(itemQuantity);
        cartDetails.setItemTotal(itemTotal);
        cartDetails.setItemStatus("Active");
        cartRepository.save(cartDetails);
        return "Successfully added to cart!";
    }


    public static String text;
    @GetMapping(path="/loginUser")
    public @ResponseBody String  getUserDetails(@RequestParam String email,@RequestParam String password) {
        Iterable<UserDetails> i = userRepository.findAll();
        for(UserDetails p: i) {
            if(p.getEmail().equals(email)){
                int passwordStatus = checkPassword(password,p.getPassword(),p.getSalt());

                if(passwordStatus==1){
                    text = String.valueOf(p.getId());
                    break;
                }else{
                    text = "Password is incorrect";
                }
            }else{
                text = "Email is incorrect";
            }
        }
        return text;
    }

    @GetMapping(path="/addNewUser")
    public @ResponseBody String getUserDetails(@RequestParam String name,@RequestParam String email,@RequestParam String mobile,@RequestParam String password){
        mobileStatus = 1;emailStatus = 1;
        Iterable<UserDetails> data = userRepository.findAll();
        for(UserDetails p: data) {
            if(p.getEmail().equals(email)){
                emailStatus = 0;
                success = "Your email is already used";
                break;
            }else{
                emailStatus = 1;
            }
            if(p.getMobile().equals(mobile)){
                mobileStatus = 0;
                success = "Your mobile number is already used";
                break;
            }else{
                mobileStatus = 1;
            }

        }

        if(mobileStatus == 1 && emailStatus == 1){
            success = getPassword(name,email,mobile,password);
        }
        return success;


    }


    @GetMapping(path="/findNameByUserId")
    public @ResponseBody String getUserById(@RequestParam Integer id) {
        Iterable<UserDetails> data = userRepository.findAll();
        String name = "";
        for(UserDetails p: data) {
            if(p.getId()==id){
                name = p.getName();
            }
        }

        return name;
    }



    public String getPassword(String name,String email,String mobile,String password) {
        UserDetails userDetails = new UserDetails();
        String getName = name;
        String getEmail = email;
        String getMobile = mobile;
        String getPassword = password;
        String salt = PasswordUtils.getSalt(30);
        String mySecurePassword = PasswordUtils.generateSecurePassword(getPassword, salt);
        userDetails.setName(getName);
        userDetails.setEmail(getEmail);
        userDetails.setMobile(getMobile);
        userDetails.setPassword(mySecurePassword);
        userDetails.setSalt(salt);
        userRepository.save(userDetails);
        success = "Successfully Registered";
        return success;
    }


    public int checkPassword(String password,String decodedpassword,String salt) {
        String providedPassword = password;
        String securePassword = decodedpassword;
        String getsalt = salt;
        boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, getsalt);
        int tempporaryStatus = 0;
        if(passwordMatch)
        {
            tempporaryStatus = 1;
        } else {
            tempporaryStatus = 0;
        }
        return tempporaryStatus;
    }


}