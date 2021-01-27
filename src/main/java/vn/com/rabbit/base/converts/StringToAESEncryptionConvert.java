package vn.com.rabbit.base.converts;

import javax.persistence.AttributeConverter;

import vn.com.rabbit.base.utils.AESEncryptionDecryptionUtils;

/**
 * @author Toàn NC7
 */
public class StringToAESEncryptionConvert implements AttributeConverter<String, String> {
    @Override
    public String convertToDatabaseColumn(String originalInput) {
        if (originalInput == null) {
            return null;
        }
        return AESEncryptionDecryptionUtils.encrypt(originalInput);
    }

    @Override
    public String convertToEntityAttribute(String encodedString) {
        if (encodedString == null) {
            return null;
        }
        return AESEncryptionDecryptionUtils.decrypt(encodedString);
    }
}
