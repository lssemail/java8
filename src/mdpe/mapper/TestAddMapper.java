package mdpe.mapper;

import mdpe.model.User;
import mdpe.model.UserDTO;
import org.junit.Test;
import org.modelmapper.*;
import org.modelmapper.spi.MappingContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/22.
 */
public class TestAddMapper {

    public static void main(String[] args) {

    }

    /**
     * 最基本的用法
     */
    @Test
    public void conver1() {

        User user = getUser();

        ModelMapper modelMapper = new ModelMapper();
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        System.out.println(userDTO);

    }

    @Test
    public void conver2() {

        User user = getUser();

        ModelMapper modelMapper = new ModelMapper();

        Provider<String> personProvider = new AbstractProvider<String>(){
            @Override
            protected String get() {
                return "这个自己定义内容";
            }
        };

        Converter<String, String> toUppercase = new AbstractConverter<String, String>() {
            @Override
            protected String convert(String s) {
                return s == null ? null : s.toUpperCase();
            }
        };

        Condition<Long, ?> gt2 = new AbstractCondition<Long, Object>() {
            @Override
            public boolean applies(MappingContext<Long, Object> context) {
                return context.getSource() > 0;
            }
        };

        PropertyMap<User, UserDTO> propertyMap = new PropertyMap<User, UserDTO>() {
            @Override
            protected void configure() {
                //使用自定义转换规则
                using(toUppercase).map(source.getNickname(),destination.getHonor());
                //使用自定义属性提供覆盖
                with(personProvider).map(source.getHonor(),destination.getNickname());
                //主动替换属性
                map(source.getAvatar()).setAvatar(null);

                skip(destination.getEmail());

                //过滤属性
                when(gt2).map().setId(1L);
            }
        };

        modelMapper.addMappings(propertyMap);
        modelMapper.validate();

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);

        System.out.println(userDTO);

    }


    @Test
    public void conver3(){
        List<User> list = getUserList();
        ModelMapper modelMapper = new ModelMapper();
        List<UserDTO> userDTOS = modelMapper.map(list,new TypeToken<List<UserDTO>>() {}.getType());
        System.out.println(userDTOS);

    }

    private User getUser(){
        User user = new User();
        user.setEmail("123@qq.com");
        user.setHonor("Fine");
        user.setId(123456L);
        user.setNickname("小红");
        user.setPassword("12345678");

        return user;
    }

    private List<User> getUserList(){

        List<User> list = new ArrayList<>();

        User user1 = getUser();
        list.add(user1);
        try {
            User user2 = (User) user1.clone();
            user2.setNickname("aaaaa");
            list.add(user2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return list;
    }
}
