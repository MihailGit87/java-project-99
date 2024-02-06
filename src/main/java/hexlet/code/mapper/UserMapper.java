package hexlet.code.mapper;

import hexlet.code.dto.UserDTO.UserCreateDto;
import hexlet.code.dto.UserDTO.UserDto;
import hexlet.code.dto.UserDTO.UserUpdateDto;
import hexlet.code.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class UserMapper {

    public abstract User map(UserCreateDto dto);
    public abstract UserDto map(User model);
    public abstract void update(UserUpdateDto dto, @MappingTarget User model);
}
